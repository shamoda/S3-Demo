package com.ssm.aws.util;

import com.ssm.aws.model.Activation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivationUtil {

    public static List<Activation> getEntries(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Activation> activations = new ArrayList<Activation>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                BigInteger accId = new BigInteger(new BigDecimal(csvRecord.get("Account_ID")).toPlainString());
                boolean tmpProd = false;
                boolean tmpSre = false;
                if (accId.equals(new BigInteger(new BigDecimal("9.00E+11").toPlainString()))) {
                    tmpProd = false;
                    tmpSre = false;
                } else if (accId.equals(new BigInteger(new BigDecimal("5.95E+11").toPlainString()))) {
                    tmpProd = false;
                    tmpSre = true;
                } else if (accId.equals(new BigInteger(new BigDecimal("3.84E+11").toPlainString()))) {
                    tmpProd = true;
                    tmpSre = false;
                } else if (accId.equals(new BigInteger(new BigDecimal("7.80E+11").toPlainString()))) {
                    tmpProd = true;
                    tmpSre = true;
                }
                Activation activation = new Activation(
                        accId,
                        csvRecord.get("Region_ID"),
                        csvRecord.get("Activation_Id"),
                        csvRecord.get("Activation_Code"),
                        tmpProd,
                        tmpSre,
                        new Date()
                );

                activations.add(activation);
            }

            return activations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
