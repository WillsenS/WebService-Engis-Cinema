
package bankservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bankservice package. 
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

    private final static QName _TransferMoneyResponse_QNAME = new QName("http://BankService/", "TransferMoneyResponse");
    private final static QName _GetNasabahByNoRekResponse_QNAME = new QName("http://BankService/", "getNasabahByNoRekResponse");
    private final static QName _IsNoRekValidResponse_QNAME = new QName("http://BankService/", "isNoRekValidResponse");
    private final static QName _IsNoRekValid_QNAME = new QName("http://BankService/", "isNoRekValid");
    private final static QName _AddVirtualAccResponse_QNAME = new QName("http://BankService/", "addVirtualAccResponse");
    private final static QName _IsTransactionExistResponse_QNAME = new QName("http://BankService/", "isTransactionExistResponse");
    private final static QName _GetNasabahByNoRek_QNAME = new QName("http://BankService/", "getNasabahByNoRek");
    private final static QName _IsTransactionExist_QNAME = new QName("http://BankService/", "isTransactionExist");
    private final static QName _TransferMoney_QNAME = new QName("http://BankService/", "TransferMoney");
    private final static QName _AddVirtualAcc_QNAME = new QName("http://BankService/", "addVirtualAcc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bankservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsTransactionExist }
     * 
     */
    public IsTransactionExist createIsTransactionExist() {
        return new IsTransactionExist();
    }

    /**
     * Create an instance of {@link TransferMoney }
     * 
     */
    public TransferMoney createTransferMoney() {
        return new TransferMoney();
    }

    /**
     * Create an instance of {@link AddVirtualAcc }
     * 
     */
    public AddVirtualAcc createAddVirtualAcc() {
        return new AddVirtualAcc();
    }

    /**
     * Create an instance of {@link IsNoRekValid }
     * 
     */
    public IsNoRekValid createIsNoRekValid() {
        return new IsNoRekValid();
    }

    /**
     * Create an instance of {@link AddVirtualAccResponse }
     * 
     */
    public AddVirtualAccResponse createAddVirtualAccResponse() {
        return new AddVirtualAccResponse();
    }

    /**
     * Create an instance of {@link IsTransactionExistResponse }
     * 
     */
    public IsTransactionExistResponse createIsTransactionExistResponse() {
        return new IsTransactionExistResponse();
    }

    /**
     * Create an instance of {@link GetNasabahByNoRek }
     * 
     */
    public GetNasabahByNoRek createGetNasabahByNoRek() {
        return new GetNasabahByNoRek();
    }

    /**
     * Create an instance of {@link TransferMoneyResponse }
     * 
     */
    public TransferMoneyResponse createTransferMoneyResponse() {
        return new TransferMoneyResponse();
    }

    /**
     * Create an instance of {@link GetNasabahByNoRekResponse }
     * 
     */
    public GetNasabahByNoRekResponse createGetNasabahByNoRekResponse() {
        return new GetNasabahByNoRekResponse();
    }

    /**
     * Create an instance of {@link IsNoRekValidResponse }
     * 
     */
    public IsNoRekValidResponse createIsNoRekValidResponse() {
        return new IsNoRekValidResponse();
    }

    /**
     * Create an instance of {@link Nasabah }
     * 
     */
    public Nasabah createNasabah() {
        return new Nasabah();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "TransferMoneyResponse")
    public JAXBElement<TransferMoneyResponse> createTransferMoneyResponse(TransferMoneyResponse value) {
        return new JAXBElement<TransferMoneyResponse>(_TransferMoneyResponse_QNAME, TransferMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNasabahByNoRekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "getNasabahByNoRekResponse")
    public JAXBElement<GetNasabahByNoRekResponse> createGetNasabahByNoRekResponse(GetNasabahByNoRekResponse value) {
        return new JAXBElement<GetNasabahByNoRekResponse>(_GetNasabahByNoRekResponse_QNAME, GetNasabahByNoRekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsNoRekValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "isNoRekValidResponse")
    public JAXBElement<IsNoRekValidResponse> createIsNoRekValidResponse(IsNoRekValidResponse value) {
        return new JAXBElement<IsNoRekValidResponse>(_IsNoRekValidResponse_QNAME, IsNoRekValidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsNoRekValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "isNoRekValid")
    public JAXBElement<IsNoRekValid> createIsNoRekValid(IsNoRekValid value) {
        return new JAXBElement<IsNoRekValid>(_IsNoRekValid_QNAME, IsNoRekValid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVirtualAccResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "addVirtualAccResponse")
    public JAXBElement<AddVirtualAccResponse> createAddVirtualAccResponse(AddVirtualAccResponse value) {
        return new JAXBElement<AddVirtualAccResponse>(_AddVirtualAccResponse_QNAME, AddVirtualAccResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTransactionExistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "isTransactionExistResponse")
    public JAXBElement<IsTransactionExistResponse> createIsTransactionExistResponse(IsTransactionExistResponse value) {
        return new JAXBElement<IsTransactionExistResponse>(_IsTransactionExistResponse_QNAME, IsTransactionExistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNasabahByNoRek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "getNasabahByNoRek")
    public JAXBElement<GetNasabahByNoRek> createGetNasabahByNoRek(GetNasabahByNoRek value) {
        return new JAXBElement<GetNasabahByNoRek>(_GetNasabahByNoRek_QNAME, GetNasabahByNoRek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTransactionExist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "isTransactionExist")
    public JAXBElement<IsTransactionExist> createIsTransactionExist(IsTransactionExist value) {
        return new JAXBElement<IsTransactionExist>(_IsTransactionExist_QNAME, IsTransactionExist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "TransferMoney")
    public JAXBElement<TransferMoney> createTransferMoney(TransferMoney value) {
        return new JAXBElement<TransferMoney>(_TransferMoney_QNAME, TransferMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddVirtualAcc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "addVirtualAcc")
    public JAXBElement<AddVirtualAcc> createAddVirtualAcc(AddVirtualAcc value) {
        return new JAXBElement<AddVirtualAcc>(_AddVirtualAcc_QNAME, AddVirtualAcc.class, null, value);
    }

}
