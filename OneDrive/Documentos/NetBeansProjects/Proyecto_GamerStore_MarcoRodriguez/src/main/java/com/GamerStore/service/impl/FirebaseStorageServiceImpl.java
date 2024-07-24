package com.GamerStore.service.impl;

import com.GamerStore.service.FirebaseStorageService;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Service
public class FirebaseStorageServiceImpl implements FirebaseStorageService {


    @Override
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        try {
            //nombre original del archivo local cliente
            String extension = archivoLocalCliente.getOriginalFilename();

            //se genera el nombre según el codigo del articulo;
            String fileName = "img" + sacaNumero(id) + extension;

            //se convierte/sube el archvo a un archivo temporal
            File file = this.convertToFile(archivoLocalCliente);

            //se copia a firestore y se obtiene el url válido de la imagen por 10 años
            String URL = this.uploadFile(file, carpeta, fileName);

            //se elimina el archivo temporal cargado desde el cliente
            file.delete();
            return URL;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String sacaNumero(Long id) {
        return String.format("%019d", id);
    }

    private File convertToFile(MultipartFile archivoLocalCliente) throws IOException {

        File tempFile = File.createTempFile("img", null);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(archivoLocalCliente.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String uploadFile(File file, String carpeta, String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

