package org.vaadin.barcodes;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

    public View() {

        // Defaults defaults
        Barcode default_code = new Barcode("https://vaadin.com/start");
        add(default_code);

        // QR Code w/ defaults
        Barcode qrcode = new Barcode("https://vaadin.com/start", Barcode.Type.qrcode);
        add(qrcode);

        // Barcode w/ defaults
        Barcode code128 = new Barcode("https://vaadin.com/start", Barcode.Type.code128);
        add(code128);

        // QR Code 400px
        Barcode qrcode_2 = new Barcode("https://vaadin.com/start", Barcode.Type.qrcode, "400px", "400px");
        add(qrcode_2);

        // Barcode 400px
        Barcode code128_2 = new Barcode("https://vaadin.com/start", Barcode.Type.code128, "400px", "100px");
        add(code128_2);

    }
}
