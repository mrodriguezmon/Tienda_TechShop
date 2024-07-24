package com.GamerStore.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    // el buket name es el <id_del_proyecto> + "appspot.com#
    final String BucketName = "techshop-70262.appspot.com";

    //ruta basica del proyecto techshop
    final String rutaSuperiorStorage = "techshop";

    //ubicación donde se encuentra el archivo de confi Json
    final String rutaJsonFile = "firebase";

    //el nobbre del archivo json
    final String archivoJsonFile = "techsop-70262-firebase-adminsdk-ftnwx-0442f8d411.json";
}
