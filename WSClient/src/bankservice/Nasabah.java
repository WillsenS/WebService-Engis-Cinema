
package bankservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nasabah complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nasabah">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no_rek" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nasabah", propOrder = {
    "nama",
    "noRek",
    "saldo"
})
public class Nasabah {

    protected String nama;
    @XmlElement(name = "no_rek")
    protected int noRek;
    protected long saldo;

    /**
     * Gets the value of the nama property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNama() {
        return nama;
    }

    /**
     * Sets the value of the nama property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNama(String value) {
        this.nama = value;
    }

    /**
     * Gets the value of the noRek property.
     * 
     */
    public int getNoRek() {
        return noRek;
    }

    /**
     * Sets the value of the noRek property.
     * 
     */
    public void setNoRek(int value) {
        this.noRek = value;
    }

    /**
     * Gets the value of the saldo property.
     * 
     */
    public long getSaldo() {
        return saldo;
    }

    /**
     * Sets the value of the saldo property.
     * 
     */
    public void setSaldo(long value) {
        this.saldo = value;
    }

}
