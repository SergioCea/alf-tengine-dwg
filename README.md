# Alfresco Transform Engine – DWG to PDF

This project implements a **custom T-Engine for Alfresco Transform Service** that allows **converting DWG files to PDF** using the **GroupDocs.Conversion** library.

---

## 🚀 Features

- **DWG → PDF** conversion  
- Compatible with **Alfresco Content Services 2x.+**  
- **The generated PDF includes a watermark**, due to the free version of GroupDocs.Conversion

---

## 📋 Requirements

To compile or run this project you need:

- **Java 17**  
- **Maven 3.5 or higher**  
- Alfresco server configured to use external Transform Engines

---

## 🔧 Build

Build the executable JAR using:

```bash
mvn clean package
```

### Running the Application

Once built, execute the following command:

```bash
java -jar target/alf-tengine-dwg-1.0.0.jar
```

### Testing with the HTML Interface

After starting the service, open the test application at [http://localhost:8090](http://localhost:8090). Use the following input values:

- **file**: Upload a DWG file.
- **sourceMimetype**: `image/vnd.dwg`.
- **targetMimetype**: `application/pdf`.

Click the **Transform** button to process the DWG file. Once transformed, the PDF will be downloaded.

## Alfresco Configuration

It will be necessary to modify the alfresco-global.properties, and add the following line:
- Add localTransform.dwg.url to the Alfresco service (http://localhost:8090/ by default).
