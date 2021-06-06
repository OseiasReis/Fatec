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
    public partial class Relatorios_Cadastrais_Disciplina : Form
    {
        public Relatorios_Cadastrais_Disciplina()
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
            _query = "Select * from disciplina order by Código";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
                dgv_rcd.DataSource = bs_disciplina;
            }
            else
            {
                MessageBox.Show("Não temos disciplina cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void Relatorios_Cadastrais_Disciplina_Load(object sender, EventArgs e)
        {
            carregar_grid();
            fim = bs_disciplina.Count;
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

        private void btn_imp_Click(object sender, EventArgs e)
        {
            printDialog1.ShowDialog();
            printDocument1.Print();
        }

        private void printDocument1_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            DataGridViewRow reg_grid;
            reg_grid = dgv_rcd.CurrentRow;

            //e.Graphics.DrawImage(Image.FromFile("Etec-Cursos.JPG"), 50, 25);
            // texto = objimpressao.DrawString(string,fonte,cor,coluna,linha)
            e.Graphics.DrawString("RELATÓRIO GERAL DE DISCIPLINAS", new System.Drawing.Font("Times new roman", 14, FontStyle.Bold), Brushes.Black, 300, 50);
            //linha – cor, espessura, posição x – ponto inicial(coluna e linha), posição y – ponto final (coluna e linha)

            linha = 100;

            // cabeçalho de colunas
            e.Graphics.DrawString("Código  ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, linha);
            e.Graphics.DrawString("Descrição   ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 100, linha);
            e.Graphics.DrawString("Sigla ", new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 500, linha);

            linha = 130;

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 75, 800, 75);

            while ((linha < 1075) & (registro != fim))
            {
                // código
                e.Graphics.DrawString(reg_grid.Cells["Código"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 50, linha);
                // descrição
                e.Graphics.DrawString(reg_grid.Cells["Descrição"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 100, linha);
                // sigla
                e.Graphics.DrawString(reg_grid.Cells["Sigla"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Regular), Brushes.Black, 500, linha);

                bs_disciplina.MoveNext(); // movendo para o próximo registro

                reg_grid = dgv_rcd.CurrentRow;  // atualizando a linha da grid para impressão

                registro += 1;   // incrementando a variável contadora de registros

                linha += 20; // incrementando a variável para pular linha
            }

            //***************************** 
            //imprime o rodapé do relatório 
            //***************************** 
            e.Graphics.DrawString("Total de Registros: " + registro.ToString(), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 550, 1100);
            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 1), 50, 1115, 800, 1115);
            e.Graphics.DrawString("Data: " + System.DateTime.Now.ToString("dd/MM/yyyy"), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 50, 1120);
            e.Graphics.DrawString("Pág: " + pag.ToString(), new System.Drawing.Font("Arial", 9, FontStyle.Bold), Brushes.Blue, 550, 1120);

            pag += 1;  // reajustando contadores de pag

            // trocando de página
            if ((pag > 1) & (registro < fim))
            {
                e.HasMorePages = true;
            }
            else
            {
                e.HasMorePages = false;
            }
            // Enquanto e.HasMorePages==true toda programação dentro do “PrintDocument” será reiniciada. 
            // Quando e.HasMorePages==false a programação do “PrintDocument” será encerrada.  

        }
    }
}
