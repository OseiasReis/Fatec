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
    public partial class Consulta_Cadastral_de_Alunos : Form
    {
        public Consulta_Cadastral_de_Alunos()
        {
            InitializeComponent();
        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_aluno;
        BindingSource bs_aluno = new BindingSource();
        String _query;

        private void carregar_grid()
        {
            _query = "Select * from alunos order by Matricula";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_aluno = _dataCommand.ExecuteReader();
            if (dr_aluno.HasRows == true)
            {
                bs_aluno.DataSource = dr_aluno;
                dgv_cons_aluno.DataSource = bs_aluno;

            }
            else
            {
                MessageBox.Show("Não temos alunos cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
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
            int a = bs_aluno.Count;
            MessageBox.Show("Quantidade: " + a, "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private void printDocument1_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            DataGridViewRow linha;
            linha = dgv_cons_aluno.CurrentRow;

            //editar imagem, para ficar pequena
            //e.Graphics.DrawImage(Image.FromFile("Etec-Cursos.PNG"), 50, 25);
            // texto = objimpressao.DrawString(string,fonte,cor,coluna,linha)
            e.Graphics.DrawString("FICHA INDIVIDUAL DE ALUNO", new System.Drawing.Font("Times new roman", 14, FontStyle.Bold), Brushes.Black, 400, 50);
            //linha – cor, espessura, posição x – ponto inicial(coluna e linha), posição y – ponto final (coluna e linha)

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 75, 800, 75);
            e.Graphics.DrawString("MATRICULA:  " + linha.Cells["Matricula"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 120);
            e.Graphics.DrawString("NOME:   " + linha.Cells["Nome"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 140);
            e.Graphics.DrawString("NASCIMENTO : " + linha.Cells["Nasc"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 160);
            e.Graphics.DrawString("ENDERECO:  " + linha.Cells["Endereco"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 180);
            e.Graphics.DrawString("NUMERO:   " + linha.Cells["Numero"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 200);
            e.Graphics.DrawString("BAIRRO : " + linha.Cells["Bairro"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 220);
            e.Graphics.DrawString("CIDADE:  " + linha.Cells["Cidade"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 240);
            e.Graphics.DrawString("CEP:   " + linha.Cells["Cep"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 260);
            e.Graphics.DrawString("RG : " + linha.Cells["RG"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 280);
            e.Graphics.DrawString("TELEFONE:  " + linha.Cells["Telefone"].Value.ToString(), new System.Drawing.Font("Arial", 10, FontStyle.Bold), Brushes.Black, 50, 300);

            e.Graphics.DrawLine(new Pen(Color.DarkBlue, 2), 50, 1100, 800, 1100);
        }

        private void Consulta_Cadastral_de_Alunos_Load(object sender, EventArgs e)
        {
            carregar_grid();
        }

        private void txt_pesq_TextChanged_1(object sender, EventArgs e)
        {
            if (cmb_escolha.Text == "Matricula")
            {
                _query = "Select * from alunos where Matricula like '" + txt_pesq.Text + "%'";
            }
            else if (cmb_escolha.Text == "Nome")
            {
                _query = "Select * from alunos where Nome like '" + txt_pesq.Text + "%'";
            }
            else if (cmb_escolha.Text == "Cidade")
            {
                _query = "Select * from alunos where Cidade like '" + txt_pesq.Text + "%'";
            }
            else
            {
                MessageBox.Show("Escolha um campo para pesquisar!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Error);
                cmb_escolha.Focus();
            }

            txt_pesq.Focus();
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_aluno = _dataCommand.ExecuteReader();
            if (dr_aluno.HasRows == true)
            {
                bs_aluno.DataSource = dr_aluno;
            }
            else
            {
                MessageBox.Show("Não temos alunos cadastrado com este nome !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_pesq.Clear();
            }
        }


    }
}
