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
    public partial class Consulta_Analitica_Disciplina : Form
    {
        OleDbConnection conn = Conexao.obterConexao();
        OleDbDataReader dr_disciplina;
        BindingSource bs_disciplina = new BindingSource();

        OleDbDataReader dr_aluno;
        BindingSource bs_aluno = new BindingSource();

        OleDbDataReader dr_menc;
        BindingSource bs_menc = new BindingSource();

        OleDbDataReader dr_reg_notas;
        BindingSource bs_reg_notas = new BindingSource();
        String _query;

        public Consulta_Analitica_Disciplina()
        {
            InitializeComponent();
        }

        private void carregar_grid()
        {
            _query = "SELECT alunos.Nome, disciplina.Sigla, disciplina.Descrição, mencao.Mencao FROM mencao INNER JOIN (disciplina INNER JOIN (alunos INNER JOIN reg_notas ON alunos.Matricula = reg_notas.Matricula) ON disciplina.Código = reg_notas.Cod_Disc) ON mencao.Mencao = reg_notas.mencao;";
            OleDbCommand _dataCommand = new OleDbCommand(_query, conn);
            dr_reg_notas = _dataCommand.ExecuteReader();
            if (dr_reg_notas.HasRows == true)
            {
                bs_reg_notas.DataSource = dr_reg_notas;
                dgv_cad.DataSource = bs_reg_notas;
            }
            else
            {
                MessageBox.Show("Não temos notas cadastrados !!!!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                dgv_cad.Rows.Clear();
                dgv_cad.Refresh();
            }
        }

        private void Consulta_Analitica_Disciplina_Load(object sender, EventArgs e)
        {
            carregar_grid();
        }
    }
}
