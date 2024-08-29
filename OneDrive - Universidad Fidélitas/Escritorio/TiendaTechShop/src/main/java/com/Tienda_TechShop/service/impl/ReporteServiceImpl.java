package com.Tienda_TechShop.service.impl;

import com.Tienda_TechShop.service.ReporteService;
import com.Tienda_TechShop.service.impl.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    DataSource datasource;

    @Override
    public ResponseEntity<Resource> generaReporte(String reporte, Map<String, Object> parametros, String tipo) throws IOException {
        try {
            
            
            //se define el estilo de respuesta
            String estilo;
            if ("vPdf".equals(tipo)) {
                estilo = "inline; ";
            } else {
                estilo = "attachment; ";
            }

            //carpeta donde estan los reportes .jasper
            String reportePath = "reportes";

            //obj donde queda el reporte generado en memoria
            ByteArrayOutputStream salida = new ByteArrayOutputStream();

            //se define el obj desde donde se lee el archivo .jasper
            ClassPathResource fuente
                    = new ClassPathResource(
                            reportePath
                            + File.separator
                            + reporte
                            + ".jasper");

            //obt donde efectivamente se lee la información
            InputStream elReporte = fuente.getInputStream();

            //obj del reporte ya generado
            var reporteJasper
                    = JasperFillManager
                            .fillReport(
                                    elReporte,
                                    parametros,
                                    datasource.getConnection());
            MediaType mediaType = null;

            String archivoSalida = "";
            byte[] data;
            if (null != tipo) switch (tipo) {
                
                    case "Pdf", "vPdf" -> {
                        JasperExportManager.exportReportToPdfStream(
                                reporteJasper, salida);
                        mediaType = MediaType.APPLICATION_PDF;
                        
                        archivoSalida = reporte + ".pdf";
                    }
                    case "Xls" -> {
                        JRXlsxExporter exportador = new JRXlsxExporter();
                        exportador.setExporterInput(
                                new SimpleExporterInput(
                                        reporteJasper));
                        exportador.setExporterOutput(
                                new SimpleOutputStreamExporterOutput(
                                        salida));
                        SimpleXlsxReportConfiguration configuracion
                                = new SimpleXlsxReportConfiguration();
                        configuracion.setDetectCellType(true);
                        configuracion.setCollapseRowSpan(true);
                        exportador.setConfiguration(configuracion);
                        exportador.exportReport();
                        mediaType = MediaType.APPLICATION_OCTET_STREAM;
                        archivoSalida = reporte + ".xlsx";
                    }
                    case "Csv" -> {
                        JRCsvExporter exportador = new JRCsvExporter();
                        exportador.setExporterInput(
                                new SimpleExporterInput(
                                        reporteJasper));
                        exportador.setExporterOutput(
                                new SimpleWriterExporterOutput(
                                        salida));
                        exportador.exportReport();
                        mediaType = MediaType.TEXT_PLAIN;
                        archivoSalida = reporte + ".csv";
                    }
                    default -> {
                    }
                }
            

            data = salida.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Disposition",
                    estilo + "filename=\"" + archivoSalida + "\"");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(data.length)
                    .contentType(mediaType)
                    .body(
                            new InputStreamResource(
                                    new ByteArrayInputStream(data)));

        } catch (SQLException | JRException e) {
            e.printStackTrace();
            return null;
        }

    }
}
