using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Proj_BD_Agenda
{
    public partial class Form1 : Form
    {

        static string strCn = "Data Source=.\\SQLEXPRESS;AttachDbFilename=|DataDirectory|\\DBAgenda.mdf;Integrated Security=True;User Instance=True";
        SqlConnection conexao = new SqlConnection(strCn);

        public Form1()
        {
            InitializeComponent();
        }

        private void tbcontatosBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.tbcontatosBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.dBAgendaDataSet1);

        }

        private void tbcontatosBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.tbcontatosBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.dBAgendaDataSet1);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'dBAgendaDataSet1.tbcontatos' table. You can move, or remove it, as needed.
            this.tbcontatosTableAdapter.Fill(this.dBAgendaDataSet1.tbcontatos);

        }

        private void btnPesquisa_Click(object sender, EventArgs e)
        {
            string pesquisa = "select * from tbcontatos where Id = " + txtID.Text;
            SqlCommand cmd = new SqlCommand(pesquisa, conexao);
            SqlDataReader DR;
            try
            {
                conexao.Open();
                DR = cmd.ExecuteReader();
                if (DR.Read())
                {
                    txtID.Text = DR.GetValue(0).ToString();
                    txtNome.Text = DR.GetValue(1).ToString();
                    txtTelefone.Text = DR.GetValue(2).ToString();
                    txtEmail.Text = DR.GetValue(3).ToString();
                }
                else
                {
                    MessageBox.Show("Registro não encontrado");
                    txtNome.Clear();
                    txtTelefone.Clear();
                    txtEmail.Clear();
                    txtID.Focus();
                }
                DR.Close();
                cmd.Dispose();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                conexao.Close();
            }
        }
    }
}
