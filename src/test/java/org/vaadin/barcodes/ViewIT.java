package org.vaadin.barcodes;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.TestBenchElement;

public class ViewIT extends AbstractViewTest {

    @Test
    public void componentWorks() {
        final TestBenchElement paperSlider = $(Barcode.ELEMENT_TAG_NAME).first();
        // Check that paper-slider contains at least one other element, which means that
        // is has been upgraded to a custom element and not just rendered as an empty
        // tag
        Assert.assertTrue(
                paperSlider.$(TestBenchElement.class).all().size() > 0);
    }
}
