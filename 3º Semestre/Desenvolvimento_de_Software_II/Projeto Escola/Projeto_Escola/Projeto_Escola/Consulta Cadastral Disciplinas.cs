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
    public partial class Consulta_Cadastral_Disciplinas : Form
    {
        public Consulta_Cadastral_Disciplinas()
        {
            InitializeComponent();
        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_disciplina;
        BindingSource bs_disciplina = new BindingSource();
        String _query;

        private void carregar_grid()
        {
            _query = "Select * from disciplina order by Código";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
                dgv_cons_disc.DataSource = bs_disciplina;

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

        private void btn_qtsl_Click(object sender, EventArgs e)
        {
            int a = bs_disciplina.Count;
            MessageBox.Show("Quantidade: " + a, "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private void Consulta_Cadastral_Disciplinas_Load(object sender, EventArgs e)
        {
            carregar_grid();
        }

        private void txt_pesq_TextChanged(object sender, EventArgs e)
        {

            if (cmb_escolha.Text == "Sigla")
            {
                _query = "Select * from disciplina where Sigla like '" + txt_pesq.Text + "%'";
            }
            else if (cmb_escolha.Text == "Descrição")
            {
                _query = "Select * from disciplina where Descrição like '" + txt_pesq.Text + "%'";
            }
            else if (cmb_escolha.Text == "Código")
            {
                _query = "Select * from disciplina where Código like '" + txt_pesq.Text + "%'";
            }
            else
            {
                MessageBox.Show("Escolha um campo para pesquisar!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Error);
                cmb_escolha.Focus();
            }

            txt_pesq.Focus();
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
            }
            else
            {
                MessageBox.Show("Não temos disciplina cadastrada com este nome !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_pesq.Clear();
            }
        }

        private void printDocument1_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            DataGridViewRow linha;
            linha = dgv_cons_disc.CurrentRow;

            //editar imagem, para ficar pequena
            //e.Graphics.DrawImage(Image.FromFile("Etec-Cursos.PNG"), 50, 25);
            // texto = objimpressao.DrawString(string,fonte,cor,coluna,linha)
            e.Graphics.DrawString("FICHA INDIVIDUAL DE DISCIPLINA", new System.Drawing.Font("Times new roman", 14, FontStyle.Bold), Brushes.Black, 400, 50);
            //linha – cor, espessura, posição x – ponto inicial(coluna e linha), posição y – ponto final (coluna e linha)

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 75, 800, 75);
            // código
            e.Graphics.DrawString("CÓDIGO DA DISC:  " + linha.Cells["Código"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 120);
            // descrição
            e.Graphics.DrawString("DESCRIÇÃO:   " + linha.Cells["Descrição"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 140);
            // sigla
            e.Graphics.DrawString("SIGLA : " + linha.Cells["Sigla"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 160);

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 1100, 800, 1100);

        }
    }
}
