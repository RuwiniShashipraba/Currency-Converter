
package stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConveterResponse_QNAME = new QName("http://currencyrate/", "conveterResponse");
    private final static QName _Conveter_QNAME = new QName("http://currencyrate/", "conveter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConveterResponse }
     * 
     */
    public ConveterResponse createConveterResponse() {
        return new ConveterResponse();
    }

    /**
     * Create an instance of {@link Conveter }
     * 
     */
    public Conveter createConveter() {
        return new Conveter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConveterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://currencyrate/", name = "conveterResponse")
    public JAXBElement<ConveterResponse> createConveterResponse(ConveterResponse value) {
        return new JAXBElement<ConveterResponse>(_ConveterResponse_QNAME, ConveterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conveter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://currencyrate/", name = "conveter")
    public JAXBElement<Conveter> createConveter(Conveter value) {
        return new JAXBElement<Conveter>(_Conveter_QNAME, Conveter.class, null, value);
    }

}
