namespace PrjCliente_conexao
{
    partial class frm_Cadastro
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label matricula;
            System.Windows.Forms.Label nomeLabel;
            System.Windows.Forms.Label nascimentoLabel;
            System.Windows.Forms.Label enderecoLabel;
            System.Windows.Forms.Label numeroLabel;
            System.Windows.Forms.Label cEPLabel;
            this.bD_ClienteDataSet = new PrjCliente_conexao.BD_ClienteDataSet();
            this.bD_ClienteBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bD_ClienteTableAdapter = new PrjCliente_conexao.BD_ClienteDataSetTableAdapters.BD_ClienteTableAdapter();
            this.tableAdapterManager = new PrjCliente_conexao.BD_ClienteDataSetTableAdapters.TableAdapterManager();
            this.lbl_matricula = new System.Windows.Forms.Label();
            this.txt_Nome = new System.Windows.Forms.TextBox();
            this.dtp_nasc = new System.Windows.Forms.MaskedTextBox();
            this.txt_endereco = new System.Windows.Forms.TextBox();
            this.txt_numero = new System.Windows.Forms.TextBox();
            this.msk_cep = new System.Windows.Forms.MaskedTextBox();
            this.btnPrim = new System.Windows.Forms.Button();
            this.btnAnt = new System.Windows.Forms.Button();
            this.btnProx = new System.Windows.Forms.Button();
            this.btnUlt = new System.Windows.Forms.Button();
            this.btn_incluir = new System.Windows.Forms.Button();
            this.btn_excluir = new System.Windows.Forms.Button();
            this.btn_alterar = new System.Windows.Forms.Button();
            this.btn_limpar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.txt_Pesquisar = new System.Windows.Forms.TextBox();
            this.clienteDataGridView = new System.Windows.Forms.DataGridView();
            this.btn_novo = new System.Windows.Forms.Button();
            matricula = new System.Windows.Forms.Label();
            nomeLabel = new System.Windows.Forms.Label();
            nascimentoLabel = new System.Windows.Forms.Label();
            enderecoLabel = new System.Windows.Forms.Label();
            numeroLabel = new System.Windows.Forms.Label();
            cEPLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.bD_ClienteDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_ClienteBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // matricula
            // 
            matricula.AutoSize = true;
            matricula.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            matricula.Location = new System.Drawing.Point(15, 9);
            matricula.Name = "matricula";
            matricula.Size = new System.Drawing.Size(63, 13);
            matricula.TabIndex = 2;
            matricula.Text = "Matricula:";
            // 
            // nomeLabel
            // 
            nomeLabel.AutoSize = true;
            nomeLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            nomeLabel.Location = new System.Drawing.Point(35, 49);
            nomeLabel.Name = "nomeLabel";
            nomeLabel.Size = new System.Drawing.Size(43, 13);
            nomeLabel.TabIndex = 4;
            nomeLabel.Text = "Nome:";
            // 
            // nascimentoLabel
            // 
            nascimentoLabel.AutoSize = true;
            nascimentoLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            nascimentoLabel.Location = new System.Drawing.Point(1, 96);
            nascimentoLabel.Name = "nascimentoLabel";
            nascimentoLabel.Size = new System.Drawing.Size(77, 13);
            nascimentoLabel.TabIndex = 6;
            nascimentoLabel.Text = "Nascimento:";
            // 
            // enderecoLabel
            // 
            enderecoLabel.AutoSize = true;
            enderecoLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            enderecoLabel.Location = new System.Drawing.Point(203, 9);
            enderecoLabel.Name = "enderecoLabel";
            enderecoLabel.Size = new System.Drawing.Size(65, 13);
            enderecoLabel.TabIndex = 8;
            enderecoLabel.Text = "Endereco:";
            // 
            // numeroLabel
            // 
            numeroLabel.AutoSize = true;
            numeroLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            numeroLabel.Location = new System.Drawing.Point(214, 49);
            numeroLabel.Name = "numeroLabel";
            numeroLabel.Size = new System.Drawing.Size(54, 13);
            numeroLabel.TabIndex = 10;
            numeroLabel.Text = "Numero:";
            // 
            // cEPLabel
            // 
            cEPLabel.AutoSize = true;
            cEPLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            cEPLabel.Location = new System.Drawing.Point(233, 96);
            cEPLabel.Name = "cEPLabel";
            cEPLabel.Size = new System.Drawing.Size(35, 13);
            cEPLabel.TabIndex = 12;
            cEPLabel.Text = "CEP:";
            // 
            // bD_ClienteDataSet
            // 
            this.bD_ClienteDataSet.DataSetName = "BD_ClienteDataSet";
            this.bD_ClienteDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bD_ClienteBindingSource
            // 
            this.bD_ClienteBindingSource.DataMember = "BD_Cliente";
            this.bD_ClienteBindingSource.DataSource = this.bD_ClienteDataSet;
            // 
            // bD_ClienteTableAdapter
            // 
            this.bD_ClienteTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BD_ClienteTableAdapter = this.bD_ClienteTableAdapter;
            this.tableAdapterManager.UpdateOrder = PrjCliente_conexao.BD_ClienteDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // lbl_matricula
            // 
            this.lbl_matricula.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "Matricula", true));
            this.lbl_matricula.Location = new System.Drawing.Point(84, 9);
            this.lbl_matricula.Name = "lbl_matricula";
            this.lbl_matricula.Size = new System.Drawing.Size(100, 23);
            this.lbl_matricula.TabIndex = 3;
            this.lbl_matricula.Text = "label1";
            // 
            // txt_Nome
            // 
            this.txt_Nome.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "Nome", true));
            this.txt_Nome.Location = new System.Drawing.Point(84, 46);
            this.txt_Nome.Name = "txt_Nome";
            this.txt_Nome.Size = new System.Drawing.Size(100, 20);
            this.txt_Nome.TabIndex = 5;
            // 
            // dtp_nasc
            // 
            this.dtp_nasc.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "Nascimento", true));
            this.dtp_nasc.Location = new System.Drawing.Point(84, 93);
            this.dtp_nasc.Mask = "00/00/0000";
            this.dtp_nasc.Name = "dtp_nasc";
            this.dtp_nasc.Size = new System.Drawing.Size(100, 20);
            this.dtp_nasc.TabIndex = 7;
            this.dtp_nasc.ValidatingType = typeof(System.DateTime);
            // 
            // txt_endereco
            // 
            this.txt_endereco.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "Endereco", true));
            this.txt_endereco.Location = new System.Drawing.Point(274, 6);
            this.txt_endereco.Name = "txt_endereco";
            this.txt_endereco.Size = new System.Drawing.Size(100, 20);
            this.txt_endereco.TabIndex = 9;
            // 
            // txt_numero
            // 
            this.txt_numero.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "Numero", true));
            this.txt_numero.Location = new System.Drawing.Point(274, 46);
            this.txt_numero.Name = "txt_numero";
            this.txt_numero.Size = new System.Drawing.Size(100, 20);
            this.txt_numero.TabIndex = 11;
            // 
            // msk_cep
            // 
            this.msk_cep.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.bD_ClienteBindingSource, "CEP", true));
            this.msk_cep.Location = new System.Drawing.Point(274, 93);
            this.msk_cep.Mask = "#####-###";
            this.msk_cep.Name = "msk_cep";
            this.msk_cep.Size = new System.Drawing.Size(100, 20);
            this.msk_cep.TabIndex = 13;
            // 
            // btnPrim
            // 
            this.btnPrim.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPrim.Location = new System.Drawing.Point(18, 145);
            this.btnPrim.Name = "btnPrim";
            this.btnPrim.Size = new System.Drawing.Size(75, 23);
            this.btnPrim.TabIndex = 14;
            this.btnPrim.Text = "Primeiro";
            this.btnPrim.UseVisualStyleBackColor = true;
            this.btnPrim.Click += new System.EventHandler(this.btnPrim_Click);
            // 
            // btnAnt
            // 
            this.btnAnt.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAnt.Location = new System.Drawing.Point(143, 145);
            this.btnAnt.Name = "btnAnt";
            this.btnAnt.Size = new System.Drawing.Size(75, 23);
            this.btnAnt.TabIndex = 15;
            this.btnAnt.Text = "Anterior";
            this.btnAnt.UseVisualStyleBackColor = true;
            this.btnAnt.Click += new System.EventHandler(this.btnAnt_Click);
            // 
            // btnProx
            // 
            this.btnProx.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnProx.Location = new System.Drawing.Point(274, 145);
            this.btnProx.Name = "btnProx";
            this.btnProx.Size = new System.Drawing.Size(75, 23);
            this.btnProx.TabIndex = 16;
            this.btnProx.Text = "Próximo";
            this.btnProx.UseVisualStyleBackColor = true;
            this.btnProx.Click += new System.EventHandler(this.btnProx_Click);
            // 
            // btnUlt
            // 
            this.btnUlt.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnUlt.Location = new System.Drawing.Point(395, 145);
            this.btnUlt.Name = "btnUlt";
            this.btnUlt.Size = new System.Drawing.Size(75, 23);
            this.btnUlt.TabIndex = 17;
            this.btnUlt.Text = "Último";
            this.btnUlt.UseVisualStyleBackColor = true;
            this.btnUlt.Click += new System.EventHandler(this.btnUlt_Click);
            // 
            // btn_incluir
            // 
            this.btn_incluir.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_incluir.Location = new System.Drawing.Point(561, 38);
            this.btn_incluir.Name = "btn_incluir";
            this.btn_incluir.Size = new System.Drawing.Size(75, 23);
            this.btn_incluir.TabIndex = 18;
            this.btn_incluir.Text = "Incluir";
            this.btn_incluir.UseVisualStyleBackColor = true;
            this.btn_incluir.Click += new System.EventHandler(this.btn_incluir_Click);
            // 
            // btn_excluir
            // 
            this.btn_excluir.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_excluir.Location = new System.Drawing.Point(561, 67);
            this.btn_excluir.Name = "btn_excluir";
            this.btn_excluir.Size = new System.Drawing.Size(75, 23);
            this.btn_excluir.TabIndex = 19;
            this.btn_excluir.Text = "Excluir";
            this.btn_excluir.UseVisualStyleBackColor = true;
            this.btn_excluir.Click += new System.EventHandler(this.btn_excluir_Click);
            // 
            // btn_alterar
            // 
            this.btn_alterar.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_alterar.Location = new System.Drawing.Point(561, 96);
            this.btn_alterar.Name = "btn_alterar";
            this.btn_alterar.Size = new System.Drawing.Size(75, 23);
            this.btn_alterar.TabIndex = 20;
            this.btn_alterar.Text = "Alterar";
            this.btn_alterar.UseVisualStyleBackColor = true;
            this.btn_alterar.Click += new System.EventHandler(this.btn_alterar_Click);
            // 
            // btn_limpar
            // 
            this.btn_limpar.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_limpar.Location = new System.Drawing.Point(561, 125);
            this.btn_limpar.Name = "btn_limpar";
            this.btn_limpar.Size = new System.Drawing.Size(75, 23);
            this.btn_limpar.TabIndex = 21;
            this.btn_limpar.Text = "Limpar";
            this.btn_limpar.UseVisualStyleBackColor = true;
            this.btn_limpar.Click += new System.EventHandler(this.btn_limpar_Click_1);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(15, 360);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(122, 13);
            this.label1.TabIndex = 22;
            this.label1.Text = "Pesquisar por nome:";
            // 
            // txt_Pesquisar
            // 
            this.txt_Pesquisar.Location = new System.Drawing.Point(143, 357);
            this.txt_Pesquisar.Name = "txt_Pesquisar";
            this.txt_Pesquisar.Size = new System.Drawing.Size(250, 20);
            this.txt_Pesquisar.TabIndex = 23;
            this.txt_Pesquisar.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // clienteDataGridView
            // 
            this.clienteDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.clienteDataGridView.Location = new System.Drawing.Point(28, 186);
            this.clienteDataGridView.Name = "clienteDataGridView";
            this.clienteDataGridView.Size = new System.Drawing.Size(608, 150);
            this.clienteDataGridView.TabIndex = 24;
            this.clienteDataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.clienteDataGridView_CellContentClick);
            // 
            // btn_novo
            // 
            this.btn_novo.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_novo.Location = new System.Drawing.Point(561, 9);
            this.btn_novo.Name = "btn_novo";
            this.btn_novo.Size = new System.Drawing.Size(75, 23);
            this.btn_novo.TabIndex = 25;
            this.btn_novo.Text = "Novo";
            this.btn_novo.UseVisualStyleBackColor = true;
            this.btn_novo.Click += new System.EventHandler(this.btn_novo_Click);
            // 
            // frm_Cadastro
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(648, 385);
            this.Controls.Add(this.btn_novo);
            this.Controls.Add(this.clienteDataGridView);
            this.Controls.Add(this.txt_Pesquisar);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_limpar);
            this.Controls.Add(this.btn_alterar);
            this.Controls.Add(this.btn_excluir);
            this.Controls.Add(this.btn_incluir);
            this.Controls.Add(this.btnUlt);
            this.Controls.Add(this.btnProx);
            this.Controls.Add(this.btnAnt);
            this.Controls.Add(this.btnPrim);
            this.Controls.Add(matricula);
            this.Controls.Add(this.lbl_matricula);
            this.Controls.Add(nomeLabel);
            this.Controls.Add(this.txt_Nome);
            this.Controls.Add(nascimentoLabel);
            this.Controls.Add(this.dtp_nasc);
            this.Controls.Add(enderecoLabel);
            this.Controls.Add(this.txt_endereco);
            this.Controls.Add(numeroLabel);
            this.Controls.Add(this.txt_numero);
            this.Controls.Add(cEPLabel);
            this.Controls.Add(this.msk_cep);
            this.Name = "frm_Cadastro";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.frm_Cadastro_Load);
            this.Click += new System.EventHandler(this.frm_Cadastro_Click);
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.frm_Cadastro_KeyUp);
            ((System.ComponentModel.ISupportInitialize)(this.bD_ClienteDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_ClienteBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.clienteDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BD_ClienteDataSet bD_ClienteDataSet;
        private System.Windows.Forms.BindingSource bD_ClienteBindingSource;
        private BD_ClienteDataSetTableAdapters.BD_ClienteTableAdapter bD_ClienteTableAdapter;
        private BD_ClienteDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.Label lbl_matricula;
        private System.Windows.Forms.TextBox txt_Nome;
        private System.Windows.Forms.MaskedTextBox dtp_nasc;
        private System.Windows.Forms.TextBox txt_endereco;
        private System.Windows.Forms.TextBox txt_numero;
        private System.Windows.Forms.MaskedTextBox msk_cep;
        private System.Windows.Forms.Button btnPrim;
        private System.Windows.Forms.Button btnAnt;
        private System.Windows.Forms.Button btnProx;
        private System.Windows.Forms.Button btnUlt;
        private System.Windows.Forms.Button btn_incluir;
        private System.Windows.Forms.Button btn_excluir;
        private System.Windows.Forms.Button btn_alterar;
        private System.Windows.Forms.Button btn_limpar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txt_Pesquisar;
        private System.Windows.Forms.DataGridView clienteDataGridView;
        private System.Windows.Forms.Button btn_novo;
    }
}

