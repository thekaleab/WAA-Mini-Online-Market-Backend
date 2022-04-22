package com.example.waaonlineminimarketbackend.service.Implementation;

import java.awt.Color;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;

import com.lowagie.text.*;

import com.lowagie.text.pdf.*;

public class InvoiceGeneratorService {
    private Order order;
    public InvoiceGeneratorService(Order order) {
        this.order = order;

    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        cell.setPhrase(new Phrase("Order ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Item", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
        order.getOrderItems().stream().forEach(orderItem -> {
            table.addCell(String.valueOf(orderItem.getId()));
            table.addCell(String.valueOf(orderItem.getProduct().getName()));
            table.addCell(String.valueOf("$ " +orderItem.getProduct().getPrice()));
            table.addCell(String.valueOf(orderItem.getQuantity()));
        });

        table.addCell("");
        table.addCell("");
        table.addCell("Total");
        table.addCell("$ "+ order.getAmount());

    }

    public ByteArrayInputStream export() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, output);
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("YOUR RECEIPT", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        document.add(new Paragraph("OrderID " + order.getId()));
        document.add(new Paragraph("Order Date: " +  order.getOrderTime().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        document.add(new Paragraph("--------------------------------------"));
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
        writer.close();
        return new ByteArrayInputStream(output.toByteArray());
    }

}