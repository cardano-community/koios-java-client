package com.reina.koios.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * GenesisInner
 */
public class GenesisInner {
  @SerializedName("networkmagic")
  private String networkmagic = null;

  @SerializedName("networkid")
  private String networkid = null;

  @SerializedName("epochlength")
  private String epochlength = null;

  @SerializedName("slotlength")
  private String slotlength = null;

  @SerializedName("maxlovelacesupply")
  private String maxlovelacesupply = null;

  @SerializedName("systemstart")
  private String systemstart = null;

  @SerializedName("activeslotcoeff")
  private String activeslotcoeff = null;

  @SerializedName("slotsperkesperiod")
  private String slotsperkesperiod = null;

  @SerializedName("maxkesrevolutions")
  private String maxkesrevolutions = null;

  @SerializedName("securityparam")
  private String securityparam = null;

  @SerializedName("updatequorum")
  private String updatequorum = null;

  @SerializedName("alonzogenesis")
  private String alonzogenesis = null;

  public GenesisInner networkmagic(String networkmagic) {
    this.networkmagic = networkmagic;
    return this;
  }

   /**
   * Unique network identifier for chain
   * @return networkmagic
  **/
  @Schema(example = "764824073", description = "Unique network identifier for chain")
  public String getNetworkmagic() {
    return networkmagic;
  }

  public void setNetworkmagic(String networkmagic) {
    this.networkmagic = networkmagic;
  }

  public GenesisInner networkid(String networkid) {
    this.networkid = networkid;
    return this;
  }

   /**
   * Network ID used at various CLI identification to distinguish between Mainnet and other networks
   * @return networkid
  **/
  @Schema(example = "Mainnet", description = "Network ID used at various CLI identification to distinguish between Mainnet and other networks")
  public String getNetworkid() {
    return networkid;
  }

  public void setNetworkid(String networkid) {
    this.networkid = networkid;
  }

  public GenesisInner epochlength(String epochlength) {
    this.epochlength = epochlength;
    return this;
  }

   /**
   * Number of slots in an epoch
   * @return epochlength
  **/
  @Schema(example = "432000", description = "Number of slots in an epoch")
  public String getEpochlength() {
    return epochlength;
  }

  public void setEpochlength(String epochlength) {
    this.epochlength = epochlength;
  }

  public GenesisInner slotlength(String slotlength) {
    this.slotlength = slotlength;
    return this;
  }

   /**
   * Duration of a single slot (in seconds)
   * @return slotlength
  **/
  @Schema(example = "1", description = "Duration of a single slot (in seconds)")
  public String getSlotlength() {
    return slotlength;
  }

  public void setSlotlength(String slotlength) {
    this.slotlength = slotlength;
  }

  public GenesisInner maxlovelacesupply(String maxlovelacesupply) {
    this.maxlovelacesupply = maxlovelacesupply;
    return this;
  }

   /**
   * Maximum smallest units (lovelaces) supply for the blockchain
   * @return maxlovelacesupply
  **/
  @Schema(example = "45000000000000000", description = "Maximum smallest units (lovelaces) supply for the blockchain")
  public String getMaxlovelacesupply() {
    return maxlovelacesupply;
  }

  public void setMaxlovelacesupply(String maxlovelacesupply) {
    this.maxlovelacesupply = maxlovelacesupply;
  }

  public GenesisInner systemstart(String systemstart) {
    this.systemstart = systemstart;
    return this;
  }

   /**
   * Timestamp for first block (genesis) on chain
   * @return systemstart
  **/
  @Schema(example = "2017-09-23T21:44:51Z", description = "Timestamp for first block (genesis) on chain")
  public String getSystemstart() {
    return systemstart;
  }

  public void setSystemstart(String systemstart) {
    this.systemstart = systemstart;
  }

  public GenesisInner activeslotcoeff(String activeslotcoeff) {
    this.activeslotcoeff = activeslotcoeff;
    return this;
  }

   /**
   * Active Slot Co-Efficient (f) - determines the _probability_ of number of slots in epoch that are expected to have blocks (so mainnet, this would be: 432000 * 0.05 &#x3D; 21600 estimated blocks)
   * @return activeslotcoeff
  **/
  @Schema(example = "0.05", description = "Active Slot Co-Efficient (f) - determines the _probability_ of number of slots in epoch that are expected to have blocks (so mainnet, this would be: 432000 * 0.05 = 21600 estimated blocks)")
  public String getActiveslotcoeff() {
    return activeslotcoeff;
  }

  public void setActiveslotcoeff(String activeslotcoeff) {
    this.activeslotcoeff = activeslotcoeff;
  }

  public GenesisInner slotsperkesperiod(String slotsperkesperiod) {
    this.slotsperkesperiod = slotsperkesperiod;
    return this;
  }

   /**
   * Number of slots that represent a single KES period (a unit used for validation of KES key evolutions)
   * @return slotsperkesperiod
  **/
  @Schema(example = "129600", description = "Number of slots that represent a single KES period (a unit used for validation of KES key evolutions)")
  public String getSlotsperkesperiod() {
    return slotsperkesperiod;
  }

  public void setSlotsperkesperiod(String slotsperkesperiod) {
    this.slotsperkesperiod = slotsperkesperiod;
  }

  public GenesisInner maxkesrevolutions(String maxkesrevolutions) {
    this.maxkesrevolutions = maxkesrevolutions;
    return this;
  }

   /**
   * Number of KES key evolutions that will automatically occur before a KES (hot) key is expired. This parameter is for security of a pool, in case an operator had access to his hot(online) machine compromised
   * @return maxkesrevolutions
  **/
  @Schema(example = "62", description = "Number of KES key evolutions that will automatically occur before a KES (hot) key is expired. This parameter is for security of a pool, in case an operator had access to his hot(online) machine compromised")
  public String getMaxkesrevolutions() {
    return maxkesrevolutions;
  }

  public void setMaxkesrevolutions(String maxkesrevolutions) {
    this.maxkesrevolutions = maxkesrevolutions;
  }

  public GenesisInner securityparam(String securityparam) {
    this.securityparam = securityparam;
    return this;
  }

   /**
   * A unit (k) used to divide epochs to determine stability window (used in security checks like ensuring atleast 1 block was created in 3*k/f period, or to finalize next epoch&#x27;s nonce at 4*k/f slots before end of epoch)
   * @return securityparam
  **/
  @Schema(example = "2160", description = "A unit (k) used to divide epochs to determine stability window (used in security checks like ensuring atleast 1 block was created in 3*k/f period, or to finalize next epoch's nonce at 4*k/f slots before end of epoch)")
  public String getSecurityparam() {
    return securityparam;
  }

  public void setSecurityparam(String securityparam) {
    this.securityparam = securityparam;
  }

  public GenesisInner updatequorum(String updatequorum) {
    this.updatequorum = updatequorum;
    return this;
  }

   /**
   * Number of BFT members that need to approve (via vote) a Protocol Update Proposal
   * @return updatequorum
  **/
  @Schema(example = "5", description = "Number of BFT members that need to approve (via vote) a Protocol Update Proposal")
  public String getUpdatequorum() {
    return updatequorum;
  }

  public void setUpdatequorum(String updatequorum) {
    this.updatequorum = updatequorum;
  }

  public GenesisInner alonzogenesis(String alonzogenesis) {
    this.alonzogenesis = alonzogenesis;
    return this;
  }

   /**
   * A JSON dump of Alonzo Genesis
   * @return alonzogenesis
  **/
  @Schema(example = "{\\\"lovelacePerUTxOWord\\\":34482,\\\"executionPrices\\\":{\\\"prSteps\\\":{\\\"numerator\\\":721,\\\"denominator\\\":10000000},...", description = "A JSON dump of Alonzo Genesis")
  public String getAlonzogenesis() {
    return alonzogenesis;
  }

  public void setAlonzogenesis(String alonzogenesis) {
    this.alonzogenesis = alonzogenesis;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenesisInner genesisInner = (GenesisInner) o;
    return Objects.equals(this.networkmagic, genesisInner.networkmagic) &&
        Objects.equals(this.networkid, genesisInner.networkid) &&
        Objects.equals(this.epochlength, genesisInner.epochlength) &&
        Objects.equals(this.slotlength, genesisInner.slotlength) &&
        Objects.equals(this.maxlovelacesupply, genesisInner.maxlovelacesupply) &&
        Objects.equals(this.systemstart, genesisInner.systemstart) &&
        Objects.equals(this.activeslotcoeff, genesisInner.activeslotcoeff) &&
        Objects.equals(this.slotsperkesperiod, genesisInner.slotsperkesperiod) &&
        Objects.equals(this.maxkesrevolutions, genesisInner.maxkesrevolutions) &&
        Objects.equals(this.securityparam, genesisInner.securityparam) &&
        Objects.equals(this.updatequorum, genesisInner.updatequorum) &&
        Objects.equals(this.alonzogenesis, genesisInner.alonzogenesis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkmagic, networkid, epochlength, slotlength, maxlovelacesupply, systemstart, activeslotcoeff, slotsperkesperiod, maxkesrevolutions, securityparam, updatequorum, alonzogenesis);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenesisInner {\n");
    
    sb.append("    networkmagic: ").append(toIndentedString(networkmagic)).append("\n");
    sb.append("    networkid: ").append(toIndentedString(networkid)).append("\n");
    sb.append("    epochlength: ").append(toIndentedString(epochlength)).append("\n");
    sb.append("    slotlength: ").append(toIndentedString(slotlength)).append("\n");
    sb.append("    maxlovelacesupply: ").append(toIndentedString(maxlovelacesupply)).append("\n");
    sb.append("    systemstart: ").append(toIndentedString(systemstart)).append("\n");
    sb.append("    activeslotcoeff: ").append(toIndentedString(activeslotcoeff)).append("\n");
    sb.append("    slotsperkesperiod: ").append(toIndentedString(slotsperkesperiod)).append("\n");
    sb.append("    maxkesrevolutions: ").append(toIndentedString(maxkesrevolutions)).append("\n");
    sb.append("    securityparam: ").append(toIndentedString(securityparam)).append("\n");
    sb.append("    updatequorum: ").append(toIndentedString(updatequorum)).append("\n");
    sb.append("    alonzogenesis: ").append(toIndentedString(alonzogenesis)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
