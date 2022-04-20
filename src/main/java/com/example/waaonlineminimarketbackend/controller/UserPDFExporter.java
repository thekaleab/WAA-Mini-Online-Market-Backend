package com.example.waaonlineminimarketbackend.controller;

import java.awt.Color;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.UserOutputDto;
import com.lowagie.text.*;

import com.lowagie.text.pdf.*;

public class UserPDFExporter {

    private List<OrderOutputDto> listOfOrder;

    public UserPDFExporter(List<OrderOutputDto> listOfOrder) {

        this.listOfOrder = listOfOrder;

    }

    private void writeTableHeader(PdfPTable table) {

        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.BLUE);

        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);

        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Order ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Order-Item", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Order-Time", font));
        table.addCell(cell);


    }
    private void writeTableData(PdfPTable table) {

        for (OrderOutputDto order : listOfOrder) {

            table.addCell(String.valueOf(order.getId()));

            table.addCell(String.valueOf(order.getAmount()));

            table.addCell(String.valueOf(order.getOrderItems()));

            table.addCell(String.valueOf(order.getStatus()));

            table.addCell(String.valueOf(order.getOrderTime()));


        }

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        font.setSize(18);

        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("YOUR RECEIPT", font);

        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);

        table.setWidthPercentage(100f);

        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});

        table.setSpacingBefore(10);

        writeTableHeader(table);

        writeTableData(table);

        document.add(table);

        document.close();

    }

}