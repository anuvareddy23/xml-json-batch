# XML to JSON Conversion using Spring Batch

This project demonstrates a Spring Batch application that reads recording data from an XML file and converts it into a structured JSON format.

## Technologies Used
- Java
- Spring Boot
- Spring Batch
- Jackson (for JSON processing)
- Maven

## Project Structure
- **Reader** – Reads recording data from XML
- **Processor** – Transforms XML data into Java objects
- **Writer** – Writes the transformed data into JSON format

## Input
The application reads data from an XML file:

src/main/resources/input.xml

Example:

```xml
<recordings>
    <recording>
        <RECORDING-TITLE-COLLECTING-SOCIETY>ZOVI ME NA PICE 2019</RECORDING-TITLE-COLLECTING-SOCIETY>
        <MAIN-ARTIST-NAME-COLLECTING-SOCIETY>JANA</MAIN-ARTIST-NAME-COLLECTING-SOCIETY>
    </recording>
</recordings>
