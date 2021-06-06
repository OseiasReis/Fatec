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
    public partial class Cadastro_Disciplinas : Form
    {
        public Cadastro_Disciplinas()
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
                Disciplina_dataGridView.DataSource = bs_disciplina;

                igualar_text();
            }
            else
            {
                MessageBox.Show("Não temos disciplina cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void igualar_text()
        {
            lbl_cod.DataBindings.Clear();
            lbl_cod.DataBindings.Add("Text", bs_disciplina, "Código");
            txt_desc.DataBindings.Clear();
            txt_desc.DataBindings.Add("Text", bs_disciplina, "Descrição");
            txt_sig.DataBindings.Clear();
            txt_sig.DataBindings.Add("Text", bs_disciplina, "Sigla");
        }

        private bool valida()
        {
            bool erro = true;
            if (txt_desc.Text == "")
            {
                MessageBox.Show("Descrição inválida. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_desc.Focus();
            }
            else if (txt_sig.Text == "")
            {
                MessageBox.Show("Sigla inválida. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_sig.Focus();
            }
            else
            {
                erro = false;
            }
            return erro;
        }

        private void limpar()
        {
            lbl_cod.Text = "";
            txt_desc.Clear();
            txt_sig.Clear();
        }
        private void btnPrim_Click(object sender, EventArgs e)
        {
            bs_disciplina.MoveFirst();
            igualar_text();
        }

        private void btnProx_Click(object sender, EventArgs e)
        {
            if (bs_disciplina.Count == bs_disciplina.Position + 1)
                MessageBox.Show("Fim de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_disciplina.MoveNext();
            igualar_text();
        }

        private void btnAnt_Click(object sender, EventArgs e)
        {
            if (bs_disciplina.Position == 0)
                MessageBox.Show("Inicio de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_disciplina.MovePrevious();
            igualar_text();
        }

        private void btnUlt_Click(object sender, EventArgs e)
        {
            bs_disciplina.MoveLast();
            igualar_text();
        }

        private void btn_incluir_Click(object sender, EventArgs e)
        {
            bool teste;
            teste = valida();
            if (teste == false)
            {
                _query = "Insert into disciplina (Descrição,Sigla) Values ";
                _query += "('" + txt_desc.Text + "','" + txt_sig.Text + "')";
                try
                {
                    OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Incluido com sucesso !!!!", "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception e2)
                {
                    MessageBox.Show("Problemas com a Inclusão !!!!\n" + e2, "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void btn_excluir_Click(object sender, EventArgs e)
        {
            _query = "delete from disciplina where Código like '" + lbl_cod.Text + "'";
            try
            {
                OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                _dataCommand.ExecuteNonQuery();
                carregar_grid();
                MessageBox.Show("Excluido com sucesso !!!!", "Exclusão", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
            catch (Exception)
            {
                MessageBox.Show("Problemas com a Exclusão !!!!", "Exclusão", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }


        private void btn_alterar_Click(object sender, EventArgs e)
        {
            bool teste;
            teste = valida();
            if (teste == false)
            {
                _query = "Update disciplina set Descrição ='" + txt_desc.Text + "',";
                _query += "Sigla = '" + txt_desc.Text + "'";
                _query += "where Código like '" + lbl_cod.Text + "'";
                try
                {
                    OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Alterado com sucesso !!!!", "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception e3)
                {
                    MessageBox.Show("Problemas com a Alteração !!!!" + e3, "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void btn_limpar_Click(object sender, EventArgs e)
        {
            limpar();
        }

        private void btn_novo_Click(object sender, EventArgs e)
        {
            limpar();
            txt_desc.Focus();
        }

        private void Cadastro_Disciplinas_Load(object sender, EventArgs e)
        {
            carregar_grid();
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            _query = "Select * from disciplina where Sigla like '" + txt_Pesquisar.Text + "%'";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_disciplina = _dataCommand.ExecuteReader();
            if (dr_disciplina.HasRows == true)
            {
                bs_disciplina.DataSource = dr_disciplina;
            }
            else
            {
                MessageBox.Show("Não temos disciplina cadastrada com este nome !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_Pesquisar.Text = "";
            }
        }
    }
}
