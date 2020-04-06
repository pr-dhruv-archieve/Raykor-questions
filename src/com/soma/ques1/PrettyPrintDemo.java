package com.soma.ques1;

import java.util.regex.Pattern;

public class PrettyPrintDemo {

	private static String getIndent(int indent) {
		String space = "";
		for (int i = 1; i <= indent; i++)
			space += "\t";
		return space;
	}

	public static String findPrettyXML(String inputXML) {
		Pattern start = Pattern.compile("<\\?(.*)>");
		Pattern opening = Pattern.compile("<\\s*\\w[^>]*>(.*?)");
		Pattern closing = Pattern.compile("<\\/(\\w+|\\W+)>");
		Pattern singleLine = Pattern.compile("<(\\w+|\\W+)>(\\w|\\W)*</(\\w+|\\W+)>");

		int indent = 0;
		boolean flag = false;
		boolean initial = true;
		String prettyXML = "";

		String[] lines = inputXML.split("\n");
		for (String line : lines) {
			if (start.matcher(line).matches()) {
				prettyXML += line + "\n";
				continue;
			} else if (closing.matcher(line).matches()) {
				indent--;
				prettyXML += getIndent(indent) + line + "\n";

			} else if (singleLine.matcher(line).matches()) {
				if (flag)
					indent++;
				prettyXML += getIndent(indent) + line + "\n";
				flag = false;
				initial = true;

			} else if (opening.matcher(line).matches()) {
				if (!initial)
					indent++;
				else
					initial = false;
				
				prettyXML += getIndent(indent) + line + "\n";
				flag = true;

			}
		}
		return prettyXML;
	}

	public static void main(String[] args) {
		String inputXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<company>\n"
				+ "<name>Raykor Technologies PVT. Ltd.</name>\n" + "<employees>\n" + "<employee id=\"1\">\n"
				+ "<name>ABC PQR</name>\n" + "<address>\n" + "<line1>M G Road</line1>\n" + "<line2>Baner</line2>\n"
				+ "<state>Maharashtra</state>\n" + "<city>Pune</city>\n" + "</address>\n" + "<phones>\n"
				+ "<mobile>9876543210</mobile>\n" + "<landline>0209876543</landline>\n" + "</phones>\n"
				+ "<education>\n" + "<degree>\n" + "<college>\n" + "<name>College of engineering</name>\n"
				+ "<address>\n" + "<line1>M G Road</line1>\n" + "<line2>Baner</line2>\n"
				+ "<state>Maharashtra</state>\n" + "<city>Pune</city>\n" + "</address>\n" + "</college>\n"
				+ "</degree>\n" + "</education>\n" + "</employee>\n" + "</employees>\n" + "</company>";

		String prettyXML = findPrettyXML(inputXML);
		prettyXML += "\b";
		System.out.println(prettyXML);
	}

}