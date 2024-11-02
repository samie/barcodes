# Barcodes

Vaadin 14 and 24 Java integration of [bwip-js](https://github.com/metafloor/bwip-js). Create various kind of barcodes and QR codes for Vaadin. List of [supported barcode types](https://github.com/metafloor/bwip-js/wiki/BWIPP-Barcode-Types).

This component is available at: https://vaadin.com/directory/component/barcodes

## Development instructions

JavaScript modules can either be published as an NPM package or be kept as local 
files in your project. The local JavaScript modules should be put in 
`src/main/resources/META-INF/frontend` so that they are automatically found and 
used in the using application.

If the modules are published then the package should be noted in the component 
using the `@NpmPackage` annotation in addition to using `@JsModule` annotation.


Starting the test/demo server:
1. Run `mvn jetty:run`.
2. Open http://localhost:8080 in the browser.

## Publishing to Vaadin Directory

You can create the zip package needed for [Vaadin Directory](https://vaadin.com/directory/) using
```
mvn versions:set -DnewVersion=1.0.0 # You cannot publish snapshot versions 
mvn install -Pdirectory
```

The package is created as `target/barcodes-1.0.0.zip`

For more information or to upload the package, visit https://vaadin.com/directory/my-components?uploadNewComponent
