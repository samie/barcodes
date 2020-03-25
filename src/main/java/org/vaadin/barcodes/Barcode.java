package org.vaadin.barcodes;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;


// Download the bwip-js JS files using NPM
@NpmPackage(value = "bwip-js", version = "2.0.6")
@Tag(Barcode.ELEMENT_TAG_NAME)
@JsModule("./src/barcode.js")
@CssImport(value = "./src/barcode.css")
/*
 */
public class Barcode extends PolymerTemplate<TemplateModel> implements HasSize {

    // Custom element tag name. This should match the client-side JS.
    public static final String ELEMENT_TAG_NAME = "barcode-bwipjs";
    private static final String DEFAULT_BARCODE_WIDTH = "200px";
    private static final String DEFAULT_BARCODE_HEIGHT = "50px";
    private static final String DEFAULT_QRCODE_WIDTH = "100px";
    private static final String DEFAULT_QRCODE_HEIGHT = "100px";

    public Barcode(String text) {
        this(text, Type.qrcode);
    }

    public Barcode(String text, Type type) {
        this(text,
                type,
                type.id.indexOf("qr") >= 0 ? DEFAULT_QRCODE_WIDTH : DEFAULT_BARCODE_WIDTH,
                type.id.indexOf("qr") >= 0 ? DEFAULT_QRCODE_HEIGHT : DEFAULT_BARCODE_HEIGHT);
    }

    public Barcode(String text, Type type, String width, String height) {
        setWidth(width);
        setHeight(height);
        getElement().callJsFunction("init", text, type.id);
    }

    public enum Type {

        auspost("auspost", "AusPost 4 State Customer Code"),
        azteccode("azteccode", "Aztec Code"),
        aztecrune("aztecrune", "Aztec Runes"),
        bc412("bc412", "BC412"),
        coop2of5("coop2of5", "COOP 2 of 5"),
        channelcode("channelcode", "Channel Code"),
        rationalizedCodabar("rationalizedCodabar", "Codabar"),
        codablockf("codablockf", "Codablock F"),
        code11("code11", "Code 11"),
        code128("code128", "Code 128"),
        code16k("code16k", "Code 16K"),
        code2of5("code2of5", "Code 25"),
        code39("code39", "Code 39"),
        code39ext("code39ext", "Code 39 Extended"),
        code49("code49", "Code 49"),
        code93("code93", "Code 93"),
        code93ext("code93ext", "Code 93 Extended"),
        codeone("codeone", "Code One"),
        azteccodecompact("azteccodecompact", "Compact Aztec Code"),
        pdf417compact("pdf417compact", "Compact PDF417"),
        raw("raw", "Custom 1D symbology"),
        daft("daft", "Custom 4 state symbology"),
        datamatrix("datamatrix", "Data Matrix"),
        datamatrixrectangular("datamatrixrectangular", "Data Matrix Rectangular"),
        datamatrixrectangularextension("datamatrixrectangularextension", "Data Matrix Rectangular Extension"),
        datalogic2of5("datalogic2of5", "Datalogic 2 of 5"),
        identcode("identcode", "Deutsche Post Identcode"),
        leitcode("leitcode", "Deutsche Post Leitcode"),
        dotcode("dotcode", "DotCode"),
        ean13("ean13", "EAN-13"),
        ean13composite("ean13composite", "EAN-13 Composite"),
        ean2("ean2", "EAN-2 (2 digit addon)"),
        ean5("ean5", "EAN-5 (5 digit addon)"),
        ean8("ean8", "EAN-8"),
        ean8composite("ean8composite", "EAN-8 Composite"),
        flattermarken("flattermarken", "Flattermarken"),
        gs1_cc("gs1-cc", "GS1 Composite 2D Component"),
        gs1datamatrix("gs1datamatrix", "GS1 Data Matrix"),
        gs1datamatrixrectangular("gs1datamatrixrectangular", "GS1 Data Matrix Rectangular"),
        databarexpanded("databarexpanded", "GS1 DataBar Expanded"),
        databarexpandedcomposite("databarexpandedcomposite", "GS1 DataBar Expanded Composite"),
        databarexpandedstacked("databarexpandedstacked", "GS1 DataBar Expanded Stacked"),
        databarexpandedstackedcomposite("databarexpandedstackedcomposite", "GS1 DataBar Expanded Stacked Composite"),
        databarlimited("databarlimited", "GS1 DataBar Limited"),
        databarlimitedcomposite("databarlimitedcomposite", "GS1 DataBar Limited Composite"),
        databaromni("databaromni", "GS1 DataBar Omnidirectional"),
        databaromnicomposite("databaromnicomposite", "GS1 DataBar Omnidirectional Composite"),
        databarstacked("databarstacked", "GS1 DataBar Stacked"),
        databarstackedcomposite("databarstackedcomposite", "GS1 DataBar Stacked Composite"),
        databarstackedomni("databarstackedomni", "GS1 DataBar Stacked Omnidirectional"),
        databarstackedomnicomposite("databarstackedomnicomposite", "GS1 DataBar Stacked Omnidirectional Composite"),
        databartruncated("databartruncated", "GS1 DataBar Truncated"),
        databartruncatedcomposite("databartruncatedcomposite", "GS1 DataBar Truncated Composite"),
        gs1northamericancoupon("gs1northamericancoupon", "GS1 North American Coupon"),
        gs1qrcode("gs1qrcode", "GS1 QR Code"),
        gs1_128("gs1-128", "GS1-128"),
        gs1_128_composite("gs1-128composite", "GS1-128 Composite"),
        ean14("ean14", "GS1-14"),
        hibcazteccode("hibcazteccode", "HIBC Aztec Code"),
        hibccodablockf("hibccodablockf", "HIBC Codablock F"),
        hibccode128("hibccode128", "HIBC Code 128"),
        hibccode39("hibccode39", "HIBC Code 39"),
        hibcdatamatrix("hibcdatamatrix", "HIBC Data Matrix"),
        hibcdatamatrixrectangular("hibcdatamatrixrectangular", "HIBC Data Matrix Rectangular"),
        hibcmicropdf417("hibcmicropdf417", "HIBC MicroPDF417"),
        hibcpdf417("hibcpdf417", "HIBC PDF417"),
        hibcqrcode("hibcqrcode", "HIBC QR Code"),
        hanxin("hanxin", "Han Xin Code"),
        iata2of5("iata2of5", "IATA 2 of 5"),
        isbn("isbn", "ISBN"),
        ismn("ismn", "ISMN"),
        issn("issn", "ISSN"),
        itf14("itf14", "ITF-14"),
        industrial2of5("industrial2of5", "Industrial 2 of 5"),
        interleaved2of5("interleaved2of5", "Interleaved 2 of 5 (ITF)"),
        code32("code32", "Italian Pharmacode"),
        japanpost("japanpost", "Japan Post 4 State Customer Code"),
        msi("msi", "MSI Modified Plessey"),
        matrix2of5("matrix2of5", "Matrix 2 of 5"),
        maxicode("maxicode", "MaxiCode"),
        microqrcode("microqrcode", "Micro QR Code"),
        micropdf417("micropdf417", "MicroPDF417"),
        symbol("symbol", "Miscellaneous symbols"),
        pdf417("pdf417", "PDF417"),
        pharmacode("pharmacode", "Pharmaceutical Binary Code"),
        pzn("pzn", "Pharmazentralnummer (PZN)"),
        plessey("plessey", "Plessey UK"),
        posicode("posicode", "PosiCode"),
        qrcode("qrcode", "QR Code"),
        kix("kix", "Royal Dutch TPG Post KIX"),
        royalmail("royalmail", "Royal Mail 4 State Customer Code"),
        mailmark("mailmark", "Royal Mail Mailmark"),
        sscc18("sscc18", "SSCC-18"),
        telepen("telepen", "Telepen"),
        telepennumeric("telepennumeric", "Telepen Numeric"),
        pharmacode2("pharmacode2", "Two-track Pharmacode"),
        upca("upca", "UPC-A"),
        upcacomposite("upcacomposite", "UPC-A Composite"),
        upce("upce", "UPC-E"),
        upcecomposite("upcecomposite", "UPC-E Composite"),
        onecode("onecode", "USPS Intelligent Mail"),
        planet("planet", "USPS PLANET"),
        postnet("postnet", "USPS POSTNET"),
        ultracode("ultracode", "Ultracode");


        private final String id;
        private final String name;

        Type(String id, String name) {
            this.id = id;
            this.name = name;
        }
        }

}
