namespace Solicitacao_Mov
{
    partial class frm_Cons_Cad_Disc
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
            this.bD_SolictDataSet = new Solicitacao_Mov.BD_SolictDataSet();
            this.bD_SolicitBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.bD_SolicitTableAdapter = new Solicitacao_Mov.BD_SolictDataSetTableAdapters.BD_SolicitTableAdapter();
            this.tableAdapterManager = new Solicitacao_Mov.BD_SolictDataSetTableAdapters.TableAdapterManager();
            this.bD_SolicitDataGridView = new System.Windows.Forms.DataGridView();
            this.lbl_titulo1 = new System.Windows.Forms.Label();
            this.cmd_escolha = new System.Windows.Forms.ComboBox();
            this.txt_Pesq = new System.Windows.Forms.TextBox();
            this.btn_imp = new System.Windows.Forms.Button();
            this.btn_vis = new System.Windows.Forms.Button();
            this.btn_Quant = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolictDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitDataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // bD_SolictDataSet
            // 
            this.bD_SolictDataSet.DataSetName = "BD_SolictDataSet";
            this.bD_SolictDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bD_SolicitBindingSource
            // 
            this.bD_SolicitBindingSource.DataMember = "BD_Solicit";
            this.bD_SolicitBindingSource.DataSource = this.bD_SolictDataSet;
            // 
            // bD_SolicitTableAdapter
            // 
            this.bD_SolicitTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.BD_SolicitTableAdapter = this.bD_SolicitTableAdapter;
            this.tableAdapterManager.UpdateOrder = Solicitacao_Mov.BD_SolictDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // bD_SolicitDataGridView
            // 
            this.bD_SolicitDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.bD_SolicitDataGridView.Location = new System.Drawing.Point(12, 153);
            this.bD_SolicitDataGridView.Name = "bD_SolicitDataGridView";
            this.bD_SolicitDataGridView.Size = new System.Drawing.Size(744, 171);
            this.bD_SolicitDataGridView.TabIndex = 1;
            // 
            // lbl_titulo1
            // 
            this.lbl_titulo1.AutoSize = true;
            this.lbl_titulo1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_titulo1.Location = new System.Drawing.Point(12, 83);
            this.lbl_titulo1.Name = "lbl_titulo1";
            this.lbl_titulo1.Size = new System.Drawing.Size(266, 17);
            this.lbl_titulo1.TabIndex = 2;
            this.lbl_titulo1.Text = "Escolha o campo a ser pesquisado:";
            this.lbl_titulo1.Click += new System.EventHandler(this.lbl_titulo1_Click);
            // 
            // cmd_escolha
            // 
            this.cmd_escolha.FormattingEnabled = true;
            this.cmd_escolha.Items.AddRange(new object[] {
            "ID",
            "Data",
            "Solicitante",
            "Desc_Prod",
            "Patrimônio",
            "Loc_Ori",
            "Loc_Dest"});
            this.cmd_escolha.Location = new System.Drawing.Point(284, 82);
            this.cmd_escolha.Name = "cmd_escolha";
            this.cmd_escolha.Size = new System.Drawing.Size(121, 21);
            this.cmd_escolha.TabIndex = 3;
            this.cmd_escolha.SelectedIndexChanged += new System.EventHandler(this.cmd_escolha_SelectedIndexChanged);
            // 
            // txt_Pesq
            // 
            this.txt_Pesq.Location = new System.Drawing.Point(439, 82);
            this.txt_Pesq.Name = "txt_Pesq";
            this.txt_Pesq.Size = new System.Drawing.Size(317, 20);
            this.txt_Pesq.TabIndex = 4;
            this.txt_Pesq.TextChanged += new System.EventHandler(this.txt_Pesq_TextChanged);
            // 
            // btn_imp
            // 
            this.btn_imp.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_imp.Location = new System.Drawing.Point(50, 364);
            this.btn_imp.Name = "btn_imp";
            this.btn_imp.Size = new System.Drawing.Size(75, 23);
            this.btn_imp.TabIndex = 5;
            this.btn_imp.Text = "Imprimir";
            this.btn_imp.UseVisualStyleBackColor = true;
            // 
            // btn_vis
            // 
            this.btn_vis.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_vis.Location = new System.Drawing.Point(330, 364);
            this.btn_vis.Name = "btn_vis";
            this.btn_vis.Size = new System.Drawing.Size(75, 23);
            this.btn_vis.TabIndex = 6;
            this.btn_vis.Text = "Visualizar";
            this.btn_vis.UseVisualStyleBackColor = true;
            // 
            // btn_Quant
            // 
            this.btn_Quant.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_Quant.Location = new System.Drawing.Point(630, 340);
            this.btn_Quant.Name = "btn_Quant";
            this.btn_Quant.Size = new System.Drawing.Size(97, 71);
            this.btn_Quant.TabIndex = 7;
            this.btn_Quant.Text = "Quantidade de Selecionados";
            this.btn_Quant.UseVisualStyleBackColor = true;
            this.btn_Quant.Click += new System.EventHandler(this.btn_Quant_Click);
            // 
            // frm_Cons_Cad_Disc
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(778, 421);
            this.Controls.Add(this.btn_Quant);
            this.Controls.Add(this.btn_vis);
            this.Controls.Add(this.btn_imp);
            this.Controls.Add(this.txt_Pesq);
            this.Controls.Add(this.cmd_escolha);
            this.Controls.Add(this.lbl_titulo1);
            this.Controls.Add(this.bD_SolicitDataGridView);
            this.Name = "frm_Cons_Cad_Disc";
            this.Text = "frm_Cons_Cad_Disc";
            this.Load += new System.EventHandler(this.frm_Cons_Cad_Disc_Load);
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolictDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bD_SolicitDataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private BD_SolictDataSet bD_SolictDataSet;
        private System.Windows.Forms.BindingSource bD_SolicitBindingSource;
        private BD_SolictDataSetTableAdapters.BD_SolicitTableAdapter bD_SolicitTableAdapter;
        private BD_SolictDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.DataGridView bD_SolicitDataGridView;
        private System.Windows.Forms.Label lbl_titulo1;
        private System.Windows.Forms.ComboBox cmd_escolha;
        private System.Windows.Forms.TextBox txt_Pesq;
        private System.Windows.Forms.Button btn_imp;
        private System.Windows.Forms.Button btn_vis;
        private System.Windows.Forms.Button btn_Quant;
    }
}