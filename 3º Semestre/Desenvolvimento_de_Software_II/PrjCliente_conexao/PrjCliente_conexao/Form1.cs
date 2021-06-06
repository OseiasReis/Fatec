using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace PrjCliente_conexao
{
    public partial class frm_Cadastro : Form
    {
        public frm_Cadastro()
        {
            InitializeComponent();
        }

        private void clientesBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.bD_ClienteBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bD_ClienteDataSet);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'bD_ClienteDataSet.Clientes' table. You can move, or remove it, as needed.
            this.bD_ClienteTableAdapter.Fill(this.bD_ClienteDataSet.BD_Cliente);

        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_clientes;
        BindingSource bs_clientes = new BindingSource();
        String _query;

        private void carregar_grid()
        {
            _query = "Select * from BD_Cliente";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_clientes = _dataCommand.ExecuteReader();
            if (dr_clientes.HasRows == true)
            {
                bs_clientes.DataSource = dr_clientes;
                clienteDataGridView.DataSource = bs_clientes;

                igualar_text();
            }
            else
            {
                MessageBox.Show("Não temos clientes cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void igualar_text()
        {
            lbl_matricula.DataBindings.Clear();
            lbl_matricula.DataBindings.Add("Text", bs_clientes, "Matricula");
            txt_Nome.DataBindings.Clear();
            txt_Nome.DataBindings.Add("Text", bs_clientes, "Nome");
            dtp_nasc.DataBindings.Clear();
            dtp_nasc.DataBindings.Add("Text", bs_clientes, "Nascimento");
            txt_endereco.DataBindings.Clear();
            txt_endereco.DataBindings.Add("Text", bs_clientes, "Endereco");
            txt_numero.DataBindings.Clear();
            txt_numero.DataBindings.Add("Text", bs_clientes, "Numero");
            msk_cep.DataBindings.Clear();
            msk_cep.DataBindings.Add("Text", bs_clientes, "CEP");
        }

        private void frm_Cadastro_Load(object sender, EventArgs e)
        {
            carregar_grid();
        }

        private void frm_Cadastro_Click(object sender, EventArgs e)
        {
            igualar_text();
        }

        private void frm_Cadastro_KeyUp(object sender, KeyEventArgs e)
        {
            igualar_text();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            _query = "Select * from BD_Cliente where nome like '" + txt_Pesquisar.Text + "%'";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_clientes = _dataCommand.ExecuteReader();
            if (dr_clientes.HasRows == true)
            {
                bs_clientes.DataSource = dr_clientes;
            }
            else
            {
                MessageBox.Show("Não temos cliente cadastrado com este nome !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_Pesquisar.Text = "";
            }
        }

        private void btnPrim_Click(object sender, EventArgs e)
        {
            // move o ponteiro de registros para a primeira posição da tabela virtual - memória
            bs_clientes.MoveFirst();
            // atualiza os campos do formulário com o registro posicionado na memória
            igualar_text();
        }

        private void btnUlt_Click(object sender, EventArgs e)
        {
            bs_clientes.MoveLast();
            igualar_text();
        }

        private void btnAnt_Click(object sender, EventArgs e)
        {
            if (bs_clientes.Position == 0)
                MessageBox.Show("Inicio de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_clientes.MovePrevious();
            igualar_text();
        }

        private void btnProx_Click(object sender, EventArgs e)
        {
            if (bs_clientes.Count == bs_clientes.Position + 1)
                MessageBox.Show("Fim de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_clientes.MoveNext();
            igualar_text();
        }

        private void clienteDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void limpar()
        {
            lbl_matricula.Text = "";
            txt_Nome.Clear();
            txt_endereco.Clear();
            txt_numero.Clear();
            msk_cep.Clear();
            dtp_nasc.Text = DateTime.Now.ToString("dd/MM/yyyy");
        }

        private void btn_novo_Click(object sender, EventArgs e)
        {
            limpar();
            txt_Nome.Focus();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (MessageBox.Show("Deseja Sair??", "Título ", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
                Conexao.fecharConexao();
            else
            {
                e.Cancel = true;
            }
        }

        private void btn_excluir_Click(object sender, EventArgs e)
        {
            _query = "delete from BD_Cliente where Matricula like '" + lbl_matricula.Text + "'";
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

        private bool valida()
        {
            bool erro = true;
            if (txt_Nome.Text == "")
            {
                MessageBox.Show("Nome inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_Nome.Focus();
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

        private void btn_alterar_Click(object sender, EventArgs e)
        {
            bool teste; // variável para receber o valor de "erro" após executar valida
            teste = valida(); // executando "valida" e armazenando o resultado na variável "erro"
            if (teste == false)
            {
                _query = "Update BD_Cliente set Nome ='" + txt_Nome.Text + "',";
                _query += "Nascimento = '" + dtp_nasc.Text + "'";
                _query += "Endereco = '" + txt_endereco.Text + "',";
                _query += "Numero = '" + txt_numero.Text + "',";
                _query += "CEP = '" + msk_cep.Text + "',";
                _query += "where Matricula like '" + lbl_matricula.Text + "'";
                try
                {
                    OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                    _dataCommand.ExecuteNonQuery();
                    carregar_grid();
                    MessageBox.Show("Alterado com sucesso !!!!", "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                catch (Exception)
                {
                    MessageBox.Show("Problemas com a Alteração !!!!", "Alteração", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void btn_incluir_Click(object sender, EventArgs e)
        {
            {
                bool teste; // variável para receber o valor de "erro" após executar valida
                teste = valida(); // executando "valida" e armazenando o resultado na variável "erro"
                if (teste == false)
                {
                    _query = "Insert into BD_Cliente (Nome,Nascimento,Endereco,Numero,CEP) Values ";
                    _query += "('" + txt_Nome.Text + "','" + dtp_nasc.Text + "','" + txt_endereco.Text + "','" + txt_numero.Text + "','" + msk_cep.Text + "')";
                    try
                    {
                        OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
                        _dataCommand.ExecuteNonQuery();
                        carregar_grid();
                        MessageBox.Show("Incluido com sucesso !!!!", "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    }
                    catch (Exception)
                    {
                        MessageBox.Show("Problemas com a Inclusão !!!!", "Inclusão", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }
        }

        private void btn_limpar_Click_1(object sender, EventArgs e)
        {
            limpar();
        }
    }
}
