package api.body;

import api.paytionPojo.*;
import base.CommonLib;

import java.util.ArrayList;
import java.util.List;

public class Requests {

    /**
     * Function:REQUEST Body for KolayPackPreAuth API
     * Description:
     * Author: Baturay Caglasin
     * Date: Nov'22
     */
    public static String KolaypackPreauthPostRequest(String transactionId, String transactionGroupId, String reconDate, String ipAddress, String companyId, String institutionId, String productId, String bankId, String transactionDate, String description, String paymentMethod, String customerReferenceType, String sun, String customerCode, String installment) {

        Paytion paytion = new Paytion();

        paytion.setTransactionId(transactionId);
        paytion.setTransactionGroupId(transactionGroupId);
        paytion.setReconDate(reconDate);
        paytion.setIpAddress(ipAddress);
        paytion.setCompanyId(Integer.valueOf(companyId));
        paytion.setInstitutionId(Integer.valueOf(institutionId));
        paytion.setProductId(Integer.valueOf(productId));
        paytion.setBankId(Integer.valueOf(bankId));
        paytion.setTransactionDate(transactionDate);
        paytion.setDescription(description);

        OriginatorInfo originatorInfo = new OriginatorInfo();
        originatorInfo.setCity(6);
        originatorInfo.setBranch("BRANCH01");
        originatorInfo.setTeller("TELLER01");
        originatorInfo.setUser("USER0001");

        List<OriginatorInfo> valuesOriginatorInfo = new ArrayList<>();
        valuesOriginatorInfo.add(originatorInfo);

        paytion.setOriginatorInfo(originatorInfo);
        paytion.setPaymentMethod(paymentMethod);
        paytion.setCustomerReferenceType(customerReferenceType);
        paytion.setSun(sun);
        paytion.setCustomerCode(customerCode);

        Card card = new Card();
        card.setPan("4022774022774026");
        card.setExpire("2026-12");
        card.setCvv("000");
        List<Card> valuesCard = new ArrayList<>();
        valuesCard.add(card);
        paytion.setCard(card);

        Secure3DInfo secure3DInfo = new Secure3DInfo();
        secure3DInfo.setMd("0300");
        secure3DInfo.setCavv("872");
        secure3DInfo.setEci("065");
        secure3DInfo.setXid("065");
        secure3DInfo.setTransactionId("40db-be8e-c3cc2b6b1c5d");
        List<Secure3DInfo> valuesSecure3DInfo = new ArrayList<>();
        valuesSecure3DInfo.add(secure3DInfo);
        paytion.setSecure3DInfo(secure3DInfo);

        Amount amount = new Amount();
        amount.setCurrency(949);
        amount.setTotal(30);
        List<Amount> valuesAmount = new ArrayList<>();
        valuesAmount.add(amount);
        paytion.setAmount(amount);

        paytion.setInstallment(Integer.valueOf(installment));
        System.out.println(CommonLib.prepJson(paytion));
        return CommonLib.prepJson(paytion);

    }
}