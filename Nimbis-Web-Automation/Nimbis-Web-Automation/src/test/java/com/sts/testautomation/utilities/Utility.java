package com.sts.testautomation.utilities;

import com.sts.testautomation.model.QRaterRq;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

public final class Utility {
    public static String username = "";
    public static String password = "";
    public static String url = "https://test.nimbis.co.za/";

    public static QRaterRq getBlackboxInput(String xml) {
        JAXBContext jaxbContext;
        QRaterRq blackboxInput = null;

        try {
            jaxbContext = JAXBContext.newInstance(QRaterRq.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            blackboxInput = (QRaterRq) jaxbUnmarshaller.unmarshal(new StringReader(xml));

            System.out.println(blackboxInput);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return blackboxInput;
    }
}
