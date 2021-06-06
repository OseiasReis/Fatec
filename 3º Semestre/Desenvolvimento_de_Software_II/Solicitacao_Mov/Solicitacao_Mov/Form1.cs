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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bD_SolicitBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.bD_SolicitBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bD_SolictDataSet);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'bD_SolictDataSet.BD_Solicit' table. You can move, or remove it, as needed.
            this.bD_SolicitTableAdapter.Fill(this.bD_SolictDataSet.BD_Solicit);

        }

        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_solict;
        BindingSource bs_solict = new BindingSource();
        String _query;

        private void carregar_grid()
        {
            _query = "Select * from BD_Solicit";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_solict = _dataCommand.ExecuteReader();
            if (dr_solict.HasRows == true)
            {
                bs_solict.DataSource = dr_solict;
                bD_SolicitDataGridView.DataSource = bs_solict;

                igualar_text();
            }
            else
            {
                MessageBox.Show("Não temos clientes cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void igualar_text()
        {
            txt_data.DataBindings.Clear();
            txt_data.DataBindings.Add("Text", bs_solict, "Data");
            txt_solic.DataBindings.Clear();
            txt_solic.DataBindings.Add("Text", bs_solict, "Solicitante");
            txt_desc.DataBindings.Clear();
            txt_desc.DataBindings.Add("Text", bs_solict, "Desc_Prod");
            txt_patri.DataBindings.Clear();
            txt_patri.DataBindings.Add("Text", bs_solict, "Patrimônio");
            txt_loc_ori.DataBindings.Clear();
            txt_loc_ori.DataBindings.Add("Text", bs_solict, "Loc_Ori");
            txt_loc_dest.DataBindings.Clear();
            txt_loc_dest.DataBindings.Add("Text", bs_solict, "Loc_Dest");
        }

        private bool valida()
        {
            bool erro = true;
            if (txt_data.MaskFull == false)
            {
                MessageBox.Show("Data inválida. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_data.Focus();
            }
            else if (txt_solic.Text == "")
            {
                MessageBox.Show("Solicitação inválida. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_solic.Focus();
            }
            else if (txt_desc.Text == "")
            {
                MessageBox.Show("Descrição inválida. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_desc.Focus();
            }
            else if (txt_patri.Text == "")
            {
                MessageBox.Show("Patrimônio inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_patri.Focus();
            }
            else if (txt_loc_dest.Text == "")
            {
                MessageBox.Show("Local de Destino inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_loc_dest.Focus();
            }
            else if (txt_loc_ori.Text == "")
            {
                MessageBox.Show("Local de Origem inválido. Redigite !!", "Atenção!!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_loc_ori.Focus();
            }
            else
            {
                erro = false;
            }
            return erro;
        }

        private void btn_incluir_Click(object sender, EventArgs e)
        {
            {
                bool teste;
                teste = valida();
                if (teste == false)
                {
                    _query = "Insert into BD_Solicit (Data,Solicitante,Desc_Prod,Patrimônio,Loc_Ori,Loc_Dest) Values ";
                    _query += "('" + txt_data.Text + "','" + txt_solic.Text + "','" + txt_desc.Text + "','" + txt_patri.Text + "','" + txt_loc_ori.Text + "','" + txt_loc_dest.Text + "')";
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

        private void btnPrim_Click(object sender, EventArgs e)
        {
            bs_solict.MoveFirst();
            igualar_text();
        }

        private void btnAnt_Click(object sender, EventArgs e)
        {
            if (bs_solict.Position == 0)
                MessageBox.Show("Inicio de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_solict.MovePrevious();
            igualar_text();
        }

        private void btnProx_Click(object sender, EventArgs e)
        {
            if (bs_solict.Count == bs_solict.Position + 1)
                MessageBox.Show("Fim de arquivo encontrado !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            else
                bs_solict.MoveNext();
            igualar_text();
        }

        private void btnUlt_Click(object sender, EventArgs e)
        {
            bs_solict.MoveLast();
            igualar_text();
        }

        private void txt_desc_TextChanged(object sender, EventArgs e)
        {

        }

        private void bD_SolicitDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void btn_Pes_Click(object sender, EventArgs e)
        {
            frm_Cons_Cad_Disc c = new frm_Cons_Cad_Disc();
            c.Show();
        }
    }
}
