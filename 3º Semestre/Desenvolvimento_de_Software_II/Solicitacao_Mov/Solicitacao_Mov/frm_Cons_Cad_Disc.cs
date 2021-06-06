using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Solicitacao_Mov
{
    public partial class frm_Cons_Cad_Disc : Form
    {
        public frm_Cons_Cad_Disc()
        {
            InitializeComponent();
        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_solict;
        BindingSource bs_solict = new BindingSource();
        String _query;

        private void bD_SolicitBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.bD_SolicitBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bD_SolictDataSet);

        }

        private void frm_Cons_Cad_Disc_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'bD_SolictDataSet.BD_Solicit' table. You can move, or remove it, as needed.
            this.bD_SolicitTableAdapter.Fill(this.bD_SolictDataSet.BD_Solicit);

        }

        private void lbl_titulo1_Click(object sender, EventArgs e)
        {

        }

        private void txt_Pesq_TextChanged(object sender, EventArgs e)
        {
            if (cmd_escolha.Text == "ID")
            {
                _query = "Select * from BD_Solicit where ID like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Data")
            {
                _query = "Select * from BD_Solicit where Data like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Solicitante")
            {
                _query = "Select * from BD_Solicit where Solicitante like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Desc_Prod")
            {
                _query = "Select * from BD_Solicit where Desc_Prod like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Patrimônio")
            {
                _query = "Select * from BD_Solicit where Patrimônio like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Loc_Ori")
            {
                _query = "Select * from BD_Solicit where Loc_Ori like '" + txt_Pesq.Text + "%'";
            }
            else if (cmd_escolha.Text == "Loc_Dest")
            {
                _query = "Select * from BD_Solicit where Loc_Dest like '" + txt_Pesq.Text + "%'";
            }
            else
            {
                MessageBox.Show("Escolha um campo para pesquisar !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                cmd_escolha.Focus();
            }

            txt_Pesq.Focus();
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_solict = _dataCommand.ExecuteReader();

            if (dr_solict.HasRows == true)
            {
                bs_solict.DataSource = dr_solict;
                bD_SolicitDataGridView.DataSource = bs_solict;
            }
            else
            {
                MessageBox.Show("Não temos nenhuma Solicitação cadastrada com este parametro!!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_Pesq.Clear();
            }
        }

        private void btn_Quant_Click(object sender, EventArgs e)
        {
            int a = bs_solict.Count;
            MessageBox.Show("Quantidade: " + a, "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private void cmd_escolha_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
