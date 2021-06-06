namespace Projeto_Escola
{
    partial class Relatorios_Cadastrais_Alunos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Relatorios_Cadastrais_Alunos));
            this.dgv_rca = new System.Windows.Forms.DataGridView();
            this.btn_imp = new System.Windows.Forms.Button();
            this.btn_visu = new System.Windows.Forms.Button();
            this.printDialog1 = new System.Windows.Forms.PrintDialog();
            this.printDocument1 = new System.Drawing.Printing.PrintDocument();
            this.printPreviewDialog1 = new System.Windows.Forms.PrintPreviewDialog();
            ((System.ComponentModel.ISupportInitialize)(this.dgv_rca)).BeginInit();
            this.SuspendLayout();
            // 
            // dgv_rca
            // 
            this.dgv_rca.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv_rca.Location = new System.Drawing.Point(12, 12);
            this.dgv_rca.Name = "dgv_rca";
            this.dgv_rca.Size = new System.Drawing.Size(909, 378);
            this.dgv_rca.TabIndex = 0;
            // 
            // btn_imp
            // 
            this.btn_imp.Location = new System.Drawing.Point(284, 417);
            this.btn_imp.Name = "btn_imp";
            this.btn_imp.Size = new System.Drawing.Size(75, 23);
            this.btn_imp.TabIndex = 1;
            this.btn_imp.Text = "Imprimir";
            this.btn_imp.UseVisualStyleBackColor = true;
            this.btn_imp.Click += new System.EventHandler(this.btn_imp_Click);
            // 
            // btn_visu
            // 
            this.btn_visu.Location = new System.Drawing.Point(576, 417);
            this.btn_visu.Name = "btn_visu";
            this.btn_visu.Size = new System.Drawing.Size(75, 23);
            this.btn_visu.TabIndex = 2;
            this.btn_visu.Text = "Visualizar";
            this.btn_visu.UseVisualStyleBackColor = true;
            this.btn_visu.Click += new System.EventHandler(this.btn_visu_Click);
            // 
            // printDialog1
            // 
            this.printDialog1.UseEXDialog = true;
            // 
            // printDocument1
            // 
            this.printDocument1.PrintPage += new System.Drawing.Printing.PrintPageEventHandler(this.printDocument1_PrintPage);
            // 
            // printPreviewDialog1
            // 
            this.printPreviewDialog1.AutoScrollMargin = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.AutoScrollMinSize = new System.Drawing.Size(0, 0);
            this.printPreviewDialog1.ClientSize = new System.Drawing.Size(400, 300);
            this.printPreviewDialog1.Enabled = true;
            this.printPreviewDialog1.Icon = ((System.Drawing.Icon)(resources.GetObject("printPreviewDialog1.Icon")));
            this.printPreviewDialog1.Name = "printPreviewDialog1";
            this.printPreviewDialog1.Visible = false;
            // 
            // Relatorios_Cadastrais_Alunos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(933, 455);
            this.Controls.Add(this.btn_visu);
            this.Controls.Add(this.btn_imp);
            this.Controls.Add(this.dgv_rca);
            this.Name = "Relatorios_Cadastrais_Alunos";
            this.Text = "Relatorios_Cadastrais_Alunos";
            this.Load += new System.EventHandler(this.Relatorios_Cadastrais_Alunos_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgv_rca)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dgv_rca;
        private System.Windows.Forms.Button btn_imp;
        private System.Windows.Forms.Button btn_visu;
        private System.Windows.Forms.PrintDialog printDialog1;
        private System.Drawing.Printing.PrintDocument printDocument1;
        private System.Windows.Forms.PrintPreviewDialog printPreviewDialog1;
    }
}