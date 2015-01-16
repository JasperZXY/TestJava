package com.jasper.testClass;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

public class Xml {
	public static void main(String[] args) {
		String fileName = "F:\\tmp\\person.xml";
		write(fileName);
		read(fileName);
		raadByXpath(fileName);
//		new Xml().readBySAX(fileName);
		System.out.println("end..............");
	}

	public static void write(String fileName) {
		DocumentBuilder builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			org.w3c.dom.Document document = builder.newDocument();
			org.w3c.dom.Element root = document.createElement("华农");
			org.w3c.dom.Element wang = document.createElement("王老师");
			wang.setAttribute("name", "王");
			org.w3c.dom.Element li = document.createElement("李老师");
			li.setAttribute("name", "李");
			wang.appendChild(document.createTextNode("我是王老师"));
			li.appendChild(document.createTextNode("我是李老师"));
			root.appendChild(wang);
			root.appendChild(li);
			document.appendChild(root);
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(
					javax.xml.transform.OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(
					javax.xml.transform.OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(
					fileName));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void read(String fileName) {
		System.out.println("read start");
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(fileName);
			Element root = document.getRootElement();
			List<?> list = root.getChildren();
			for (int i = 0; i < list.size(); i++) {
				Element teacher = (Element) list.get(i);
				System.out.println(teacher.getAttributeValue("name") + "->"
						+ teacher.getText());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("read end");
	}
	
	public static void raadByXpath(String fileName) {
		System.out.println("raadByXpath start");
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document document_ = db.parse(new FileInputStream(fileName));

			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath_ = xpathFactory.newXPath();
			
			System.out.println(xpath_.compile("/华农/王老师").evaluate(document_));
			System.out.println(xpath_.compile("/华农/李老师").evaluate(document_));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("raadByXpath end");
	}
	
	public void readBySAX(String fileName) {
		System.out.println("readBySAX start");
		try {
			SAXHandler handler = new SAXHandler();
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(fileName, handler);
			Hashtable hashtable = handler.table;
			System.out.println(hashtable);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("readBySAX end");
	}

	@SuppressWarnings("deprecation")
	class SAXHandler extends HandlerBase {
		private Hashtable table = new Hashtable();
		private String currentElement = null;
		private String currentValue = null;

		public void setTable(Hashtable table) {
			this.table = table;
		}

		public Hashtable getTable() {
			return table;
		}

		public void startElement(String tag, AttributeList attrs)
				throws SAXException {
			currentElement = tag;
		}

		public void characters(char[] ch, int start, int length)
				throws SAXException {
			currentValue = new String(ch, start, length);
		}

		public void endElement(String name) throws SAXException {
			if (currentElement.equals(name))
				table.put(currentElement, currentValue);
		}
	}

}
