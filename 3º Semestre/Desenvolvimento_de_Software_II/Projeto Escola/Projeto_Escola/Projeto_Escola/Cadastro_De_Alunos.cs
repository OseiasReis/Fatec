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
    public partial class Cadastro_De_Alunos : Form
    {
        public Cadastro_De_Alunos()
        {
            InitializeComponent();
        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_alunos;
        BindingSource bs_alunos = new BindingSource();
        String _query;

        private void carregar_grid()
        {
            _query = "Select * from alunos order by Matricula";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_alunos = _dataCommand.ExecuteReader();
            if (dr_alunos.HasRows == true)
            {
                bs_alunos.DataSource = dr_alunos;
                Aluno_dataGridView.DataSource = bs_alunos;

                igualar_text();
            }
            else
            {
                MessageBox.Show("Não temos alunos cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void igualar_text()
        {
            lbl_matricula.DataBindings.Clear();
            lbl_matricula.DataBindings.Add("Text", bs_alunos, "Matricula");
            txt_nome.DataBindings.Clear();
            txt_nome.DataBindings.Add("Text", bs_alunos, "Nome");
            dtp_nasc.DataBindings.Clear();
            dtp_nasc.DataBindings.Add("Text", bs_alunos, "Nasc");
            txt_endereco.DataBindings.Clear();
            txt_endereco.DataBindings.Add("Text", bs_alunos, "Endereco");
            txt_numero.DataBindings.Clear();
            txt_numero.DataBindings.Add("Text", bs_alunos, "Numero");
            txt_bairro.DataBindings.Clear();
            txt_bairro.DataBindings.Add("Text", bs_alunos, "Bairro");
            txt_cidade.DataBindings.Clear();
            txt_cidade.DataBindings.Add("Text", bs_alunos, "Cidade");
            mks_rg.DataBindings.Clear();
            mks_rg.DataBindings.Add("Text", bs_alunos, "RG");
            mks_telefone.DataBindings.Clear();
            mks_telefone.DataBindings.Add("Text", bs_alunos, "Telefone");
            msk_cep.DataBindings.Clear();
            msk_cep.DataBindings.Add("Text", bs_alunos, "CEP");
        }

        private bool valida()
        {
            bool erro = true;
            if (txt_nome.Text == "")
            {
                MessageBox.Show("Nome inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_nome.Focus();
            }
            else if (txt_endereco.Text == "")
            {
                MessageBox.Show("Endereço inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_endereco.Focus();
            }
            else if (txt_numero.Text == "")
            {
                MessageBox.Show("Número da residência inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_numero.Focus();
            }
            else if (mks_rg.Text == "")
            {
                MessageBox.Show("RG inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                mks_rg.Focus();
            }
            else if (msk_cep.MaskFull == false)
            {
                MessageBox.Show("Cep inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                msk_cep.Focus();
            }
            else
            {
                erro = false;
            }
            return erro;
        }

        private void limpar()
        {
            lbl_matricula.Text = "";
            txt_nome.Clear();
            txt_endereco.Clear();
            txt_numero.Clear();
            txt_bairro.Clear();
            txt_cidade.Clear();
            msk_cep.Clear();
            mks_rg.Clear();
            mks_telefone.Clear();
            dtp_nasc.Text = DateTime.Now.ToString("dd/MM/yyyy");
        }

        private void btnPrim_Click(object sender, EventArgs e)
        {
            bs_alunos.MoveFirst();
            igualar_text();
        }

        private void btnAnt_Click(object sender, EventArgs e)
        {
            if (bs_alunos.Position == 0)
                MessageBox.Show("Inicio de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_alunos.MovePrevious();
            igualar_text();
        }

        private void btnProx_Click(object sender, EventArgs e)
        {
            if (bs_alunos.Count == bs_alunos.Position + 1)
                MessageBox.Show("Fim de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_alunos.MoveNext();
            igualar_text();
        }

        private void btnUlt_Click(object sender, EventArgs e)
        {
            bs_alunos.MoveLast();
            igualar_text();
        }


        private void btn_incluir_Click(object sender, EventArgs e)
        {
            bool teste;
            teste = valida(); 
            if (teste == false)
            {
                _query = "Insert into alunos (Nome,Nasc,Endereco,Numero,Bairro,Cidade,CEP,RG,Telefone) Values ";
                _query += "('" + txt_nome.Text + "','" + dtp_nasc.Text + "','" + txt_endereco.Text + "','" + txt_numero.Text + "','" + txt_bairro.Text + "','" + txt_cidade.Text + "','" + msk_cep.Text + "','" + mks_rg.Text + "','" + mks_telefone.Text + "')";
                try
                {
                    OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Incluido com sucesso !!!!", "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception e2)
                {
                    MessageBox.Show("Problemas com a Inclusão !!!!\n"+e2, "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void btn_excluir_Click(object sender, EventArgs e)
        {
            _query = "delete from alunos where Matricula like '" + lbl_matricula.Text + "'";
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
                _query = "Update alunos set Nome ='" + txt_nome.Text + "',";
                _query += "Nasc = '" + dtp_nasc.Text + "',";
                _query += "Endereco = '" + txt_endereco.Text + "',";
                _query += "Numero = '" + txt_numero.Text + "',";
                _query += "Bairro = '" + txt_bairro.Text + "',";
                _query += "Cidade = '" + txt_cidade.Text + "',";
                _query += "CEP = '" + msk_cep.Text + "',";
                _query += "RG = '" + mks_rg.Text + "',";
                _query += "Telefone = '" + mks_telefone.Text + "'";
                _query += "where Matricula like '" + lbl_matricula.Text + "'";
                try
                {
                    OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Alterado com sucesso !!!!", "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception e3)
                {
                    MessageBox.Show("Problemas com a Alteração !!!!" +e3, "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Error);
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
            txt_nome.Focus();
        }

        private void Cadastro_De_Alunos_Load(object sender, EventArgs e)
        {

            carregar_grid();
        }

        private void txt_pesq_TextChanged(object sender, EventArgs e)
        {
            _query = "Select * from alunos where nome like '" + txt_Pesquisar.Text + "%'";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_alunos = _dataCommand.ExecuteReader();
            if (dr_alunos.HasRows == true)
            {
                bs_alunos.DataSource = dr_alunos;
            }
            else
            {
                MessageBox.Show("Não temos aluno cadastrado com este nome !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_Pesquisar.Text = "";
            }
        }
    }
}
