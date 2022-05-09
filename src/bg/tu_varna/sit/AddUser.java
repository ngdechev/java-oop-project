package bg.tu_varna.sit;

import java.io.*;
import java.util.Scanner;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class AddUser {
    private String username;
    private String password;
    private String role;

    public AddUser() {
    }

    // Get info about new user
    private void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("username: ");
        this.username = scanner.next();
        System.out.print("password: ");
        this.password = scanner.next();
        System.out.print("role: ");
        this.role = scanner.next();
    }

    // Adding the new user to xml file
    public void addUser() {
        this.register();

        try {
            File xmlFile = new File("C:\\Users\\1005\\Desktop\\Library\\users.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element documentElement = document.getDocumentElement();

            // Create "username" subchild element
            Element usernameNode = document.createElement("username");
            usernameNode.setTextContent(this.username);

            // Create "password" subchild element
            Element passwordNode = document.createElement("password");
            passwordNode.setTextContent(this.password);

            // Create "role" subchild element
            Element roleNode = document.createElement("role");
            roleNode.setTextContent(this.role);

            // Create the child element
            Element nodeElement = document.createElement("user");

            // Append elements
            nodeElement.appendChild(usernameNode);
            nodeElement.appendChild(passwordNode);
            nodeElement.appendChild(roleNode);

            documentElement.appendChild(nodeElement);
            document.replaceChild(documentElement, documentElement);
            Transformer tFormer =
                    TransformerFactory.newInstance().newTransformer();
            tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
            Source source = new DOMSource(document);
            Result result = new StreamResult(xmlFile);
            tFormer.transform(source, result);


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
