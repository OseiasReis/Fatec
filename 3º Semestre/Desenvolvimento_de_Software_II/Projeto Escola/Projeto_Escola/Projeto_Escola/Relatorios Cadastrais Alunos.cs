using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Projeto_Escola
{
    public partial class Relatorios_Cadastrais_Alunos : Form
    {
        public Relatorios_Cadastrais_Alunos()
        {
            InitializeComponent();
        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_disciplina;
        BindingSource bs_disciplina = new BindingSource();
        String _query;

        public int pag = 1; // variável para controlar o salto de página
        int registro, linha = 0; //variável contadora de registros e linhas impressas, 
        int fim = 0;    //variável que controla o fim da impressão

        private void carregar_grid()
        {
            _query = "Select * from alunos order by Matricula";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
                dgv_rca.DataSource = bs_disciplina;
            }
            else
            {
                MessageBox.Show("Não temos disciplina cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void btn_imp_Click(object sender, EventArgs e)
        {
            printDialog1.ShowDialog();
            printDocument1.Print();
        }

        private void btn_visu_Click(object sender, EventArgs e)
        {
            printPreviewDialog1.Text = " Visualizando a impressão";   // título da janela
            printPreviewDialog1.Document = printDocument1;
            printPreviewDialog1.WindowState = FormWindowState.Maximized;  // status da janela do preview
            printPreviewDialog1.PrintPreviewControl.Columns = 2;   //  quantas páginas serão mostradas na tela
            printPreviewDialog1.PrintPreviewControl.Zoom = 0.6;   //  zoom inicial do preview
            printPreviewDialog1.ShowDialog();
        }

        private void Relatorios_Cadastrais_Alunos_Load(object sender, EventArgs e)
        {
            carregar_grid();
            fim = bs_disciplina.Count;
        }

        private void printDocument1_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            DataGridViewRow reg_grid;
            reg_grid = dgv_rca.CurrentRow;

            //e.Graphics.DrawImage(Image.FromFile("Etec-Cursos.JPG"), 50, 25);
            // texto = objimpressao.DrawString(string,fonte,cor,coluna,linha)
            e.Graphics.DrawString("RELATÓRIO GERAL DE ALUNOS", new System.Drawing.Font("Times new roman", 14, FontStyle.Bold), Brushes.Black, 300, 50);
            //linha – cor, espessura, posição x – ponto inicial(coluna e linha), posição y – ponto final (coluna e linha)

            linha = 100;

            // cabeçalho de colunas
            e.Graphics.DrawString("ID  ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, linha);
            e.Graphics.DrawString("Nome   ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 80, linha);
            e.Graphics.DrawString("Nascimento ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 140, linha);
            e.Graphics.DrawString("Endereço ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 230, linha);
            e.Graphics.DrawString("Numero ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 360, linha);
            e.Graphics.DrawString("Bairro ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 420, linha);
            e.Graphics.DrawString("Cidade ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 510, linha);
            e.Graphics.DrawString("CEP ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 590, linha);
            e.Graphics.DrawString("RG ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 660, linha);
            e.Graphics.DrawString("Telefone ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 750, linha);

            linha = 130;

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 75, 800, 75);

            while ((linha < 1075) & (registro != fim))
            {
                e.Graphics.DrawString(reg_grid.Cells["Matricula"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 50, linha);
                e.Graphics.DrawString(reg_grid.Cells["Nome"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 80, linha);
                e.Graphics.DrawString(reg_grid.Cells["Nasc"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 140, linha);
                e.Graphics.DrawString(reg_grid.Cells["Endereco"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 230, linha);
                e.Graphics.DrawString(reg_grid.Cells["Numero"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 360, linha);
                e.Graphics.DrawString(reg_grid.Cells["Bairro"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 420, linha);
                e.Graphics.DrawString(reg_grid.Cells["Cidade"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 510, linha);
                e.Graphics.DrawString(reg_grid.Cells["CEP"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 590, linha);
                e.Graphics.DrawString(reg_grid.Cells["RG"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 660, linha);
                e.Graphics.DrawString(reg_grid.Cells["Telefone"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 750, linha);

                bs_disciplina.MoveNext();

                reg_grid = dgv_rca.CurrentRow;

                registro += 1;

                linha += 20;
            }

            e.Graphics.DrawString("Total de Registros: " + registro.ToString(), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 550, 1100);
            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 1), 50, 1115, 800, 1115);
            e.Graphics.DrawString("Data: " + System.DateTime.Now.ToString("dd/MM/yyyy"), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 50, 1120);
            e.Graphics.DrawString("Pág: " + pag.ToString(), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 550, 1120);

            pag += 1;

            if ((pag > 1) & (registro < fim))
            {
                e.HasMorePages = true;
            }
            else
            {
                e.HasMorePages = false;
            }
        }
    }
}
