package com.locar.regras_negocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarPdf {
    public void gerarPDF(String nome, String cpf, String email, String telefone, String placa, String marca, String modelo,
                          String categoria, String ano, String kmRodados, double valorDiaria, int diasLocados, double valorTotal,
                          String formaPagamento) {
        Document document = new Document();
        try {

            String diretorio = "C:\\Users\\mathe\\Downloads\\pdfs\\";
            String nomeArquivo = getNovoNomeArquivo(diretorio, "Locacao");

            PdfWriter.getInstance(document, new FileOutputStream(diretorio + nomeArquivo));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subTituloFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font conteudoFont = new Font(Font.FontFamily.HELVETICA, 12);

            Paragraph titulo = new Paragraph("INFORMAÇÕES DE LOCAÇÃO\n\n", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph("Cliente", subTituloFont));
            document.add(new Paragraph("Nome: " + nome, conteudoFont));
            document.add(new Paragraph("CPF: " + cpf, conteudoFont));
            document.add(new Paragraph("E-mail: " + email, conteudoFont));
            document.add(new Paragraph("Telefone: " + telefone, conteudoFont));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Veículo", subTituloFont));
            document.add(new Paragraph("Placa: " + placa, conteudoFont));
            document.add(new Paragraph("Marca: " + marca, conteudoFont));
            document.add(new Paragraph("Modelo: " + modelo, conteudoFont));
            document.add(new Paragraph("Categoria: " + categoria, conteudoFont));
            document.add(new Paragraph("Ano: " + ano, conteudoFont));
            document.add(new Paragraph("Km Rodados: " + kmRodados, conteudoFont));
            document.add(new Paragraph("\n"));


            document.add(new Paragraph("Dados da Locação", subTituloFont));
            document.add(new Paragraph("Valor da diária: R$ " + String.format("%.2f", valorDiaria), conteudoFont));
            document.add(new Paragraph("Dias locados: " + diasLocados, conteudoFont));
            document.add(new Paragraph("Valor Total: R$ " + String.format("%.2f", valorTotal), conteudoFont));
            document.add(new Paragraph("Forma de pagamento: " + formaPagamento, conteudoFont));

            document.close();
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getNovoNomeArquivo(String diretorio, String baseNome) {
        int numero = 1;
        File arquivo;
        do {
            String nomeArquivo = baseNome + numero + ".pdf";
            arquivo = new File(diretorio + nomeArquivo);
            numero++;
        } while (arquivo.exists());
        return baseNome + (numero - 1) + ".pdf";
    }
}