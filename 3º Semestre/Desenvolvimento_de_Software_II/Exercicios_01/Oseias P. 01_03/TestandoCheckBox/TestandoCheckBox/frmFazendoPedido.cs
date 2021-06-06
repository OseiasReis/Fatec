using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace TestandoCheckBox
{
    public partial class frmFazendoPedido : Form
    {
        public frmFazendoPedido()
        {
            InitializeComponent();
        }

        private void btnVerificar_Click(object sender, EventArgs e)
        {
            double qtdChoop = Convert.ToDouble(txtQtdChoop.Text);
            double qtdPetisco = Convert.ToDouble(txtQtdPetisco.Text);
            double qtdRefeicao = Convert.ToDouble(txtQtdRefeicao.Text);
            double result1 = 0, result2 = 0, result3 = 0;
            if (chkChoop.Checked == true)
            {
                result1 = qtdChoop * 4.50;
            }
            if (chkPetisco.Checked == true)
            {
                result2 = qtdPetisco * 7.90;
            }
            if (chkRefeicao.Checked == true)
            {
                result3 = qtdRefeicao * 15.90;
            }

            double totalParcial = result1 + result2 + result3;
            txtTotalParcial.Text = Convert.ToString(totalParcial);

            double taxaServico = (totalParcial * 10) / 100;
            txtTaxaServico.Text = Convert.ToString(taxaServico);
            txtTotalPargar.Text = Convert.ToString(totalParcial + taxaServico);
        }
    }
}
