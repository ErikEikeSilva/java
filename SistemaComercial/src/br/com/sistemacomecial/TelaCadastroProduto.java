package br.com.sistemacomecial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroProduto extends JFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelTop = new JPanel(new GridLayout(3, 2));
        painelTop.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelTop.add(txtNome);

        painelTop.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        painelTop.add(txtPreco);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir");

        painelTop.add(btnSalvar);
        painelTop.add(btnExcluir);

        modelo = new DefaultTableModel(new Object[]{"Nome", "Preço"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(painelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Ações dos botões
        btnSalvar.addActionListener(e -> salvarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());
    }

    private void salvarProduto() {
        String nome = txtNome.getText();
        String preco = txtPreco.getText();

        if (nome.isEmpty() || preco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
        } else {
            modelo.addRow(new Object[]{nome, preco});
            txtNome.setText("");
            txtPreco.setText("");
        }
    }

    private void excluirProduto() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            modelo.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroProduto().setVisible(true);
        });
    }
}