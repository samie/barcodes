import { LitElement, html, css } from 'lit';
import bwipjs from 'bwip-js'; // import bwip-js from NPM

/**
 * This is our Web Component wrapper for the bwip-js object.
 * 
 * It defines some styles, web component registration methods, and some custom API methods we can call from Java.
 * 
 * It extends ThemableMixin so that Vaadin styles can be applied easily (for instance in the margin style).
 */
class Barcode extends LitElement {

    // CSS styles for the canvas element
    static styles = css`
        canvas {
            display: block;
        }
    `;

	/**
	 * This method creates the DOM for our web component. We define some styles and 
	 * finally a single DIV element to hold our map.
	 * 
	 * This is standard Web Component API.
	 */
    render() {
        return html`
            <canvas id="canvas"></canvas>
        `;
    }

    /**
     * Identity method for our web component, see also customElements.define() at the bottom of this file.
     */
    static get is() {
        return "barcode-bwipjs"; // must match @Tag in the Java file
    }
    
    /**
     * The default for Lit is to create a shadow root for each element. In this case, touch events will
     * conflict with Lit helpers so we use regular (light) DOM instead.
     */
    createRenderRoot() {
        return this; // don't create shadow root, just append the content
    }

    firstUpdated() {
        super.firstUpdated();
        // The following call was originally in init() but since it is called before the first render it will fail
        // Moving the initialisation here fixes the issue
        this.barcode = bwipjs.toCanvas(this.querySelector("#canvas"), this.options);
    }

    /**
     * Again, we can't use Shadow DOM because it conflicts (see above). Here we check if this element is
     * used inside a shadow root without a <slot>.
     */
    connectedCallback() {
    	super.connectedCallback();
    	
    	var element = this;
        while(element.parentNode && (element = element.parentNode)) {
            if(element instanceof ShadowRoot){
                console.error("This element does not support shadow roots. Please use a <slot> for the element instead.", element);
            }
        }
    }

    /** Set the barcode text content and type.
     */
    init(text, bcid) {
        const devicePixelRatio = window.devicePixelRatio || 1;
        this.options = {
            bcid:        bcid,                 // Barcode type
            text:        text,                 // Text to encode
            scale:       devicePixelRatio * 2, // Scaling factor based on device pixels
            includetext: true,                 // Show human-readable text, if available
            textxalign:  'center',             // Always good to set this
        };
    }
}

customElements.define(Barcode.is, Barcode); // Registers this custom element with the browser
