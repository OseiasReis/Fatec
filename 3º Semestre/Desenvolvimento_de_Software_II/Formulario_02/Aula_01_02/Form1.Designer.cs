namespace Aula_01_02
{
    partial class Form1
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
            this.minhaLabel = new System.Windows.Forms.Label();
            this.btnSair = new System.Windows.Forms.Button();
            this.btnLimpar = new System.Windows.Forms.Button();
            this.btnExibir = new System.Windows.Forms.Button();
            this.btnExe1 = new System.Windows.Forms.Button();
            this.btnExe2 = new System.Windows.Forms.Button();
            this.btnExe3 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // minhaLabel
            // 
            this.minhaLabel.AutoSize = true;
            this.minhaLabel.Location = new System.Drawing.Point(108, 55);
            this.minhaLabel.Name = "minhaLabel";
            this.minhaLabel.Size = new System.Drawing.Size(71, 13);
            this.minhaLabel.TabIndex = 0;
            this.minhaLabel.Text = "Hello World!!!";
            // 
            // btnSair
            // 
            this.btnSair.Location = new System.Drawing.Point(12, 134);
            this.btnSair.Name = "btnSair";
            this.btnSair.Size = new System.Drawing.Size(75, 23);
            this.btnSair.TabIndex = 1;
            this.btnSair.Text = "Sair";
            this.btnSair.UseVisualStyleBackColor = true;
            this.btnSair.Click += new System.EventHandler(this.btnSair_Click);
            // 
            // btnLimpar
            // 
            this.btnLimpar.Location = new System.Drawing.Point(104, 134);
            this.btnLimpar.Name = "btnLimpar";
            this.btnLimpar.Size = new System.Drawing.Size(75, 23);
            this.btnLimpar.TabIndex = 2;
            this.btnLimpar.Text = "Limpar";
            this.btnLimpar.UseVisualStyleBackColor = true;
            this.btnLimpar.Click += new System.EventHandler(this.btnLimpar_Click);
            // 
            // btnExibir
            // 
            this.btnExibir.Location = new System.Drawing.Point(197, 134);
            this.btnExibir.Name = "btnExibir";
            this.btnExibir.Size = new System.Drawing.Size(75, 23);
            this.btnExibir.TabIndex = 3;
            this.btnExibir.Text = "Exibir";
            this.btnExibir.UseVisualStyleBackColor = true;
            this.btnExibir.Click += new System.EventHandler(this.btnExibir_Click);
            // 
            // btnExe1
            // 
            this.btnExe1.Location = new System.Drawing.Point(12, 195);
            this.btnExe1.Name = "btnExe1";
            this.btnExe1.Size = new System.Drawing.Size(75, 23);
            this.btnExe1.TabIndex = 4;
            this.btnExe1.Text = "Exemplo 1";
            this.btnExe1.UseVisualStyleBackColor = true;
            this.btnExe1.Click += new System.EventHandler(this.btnExe1_Click);
            // 
            // btnExe2
            // 
            this.btnExe2.Location = new System.Drawing.Point(104, 195);
            this.btnExe2.Name = "btnExe2";
            this.btnExe2.Size = new System.Drawing.Size(75, 23);
            this.btnExe2.TabIndex = 5;
            this.btnExe2.Text = "Exemplo 2";
            this.btnExe2.UseVisualStyleBackColor = true;
            this.btnExe2.Click += new System.EventHandler(this.btnExe2_Click);
            // 
            // btnExe3
            // 
            this.btnExe3.Location = new System.Drawing.Point(197, 195);
            this.btnExe3.Name = "btnExe3";
            this.btnExe3.Size = new System.Drawing.Size(75, 23);
            this.btnExe3.TabIndex = 6;
            this.btnExe3.Text = "Exemplo 3";
            this.btnExe3.UseVisualStyleBackColor = true;
            this.btnExe3.Click += new System.EventHandler(this.btnExe3_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 262);
            this.Controls.Add(this.btnExe3);
            this.Controls.Add(this.btnExe2);
            this.Controls.Add(this.btnExe1);
            this.Controls.Add(this.btnExibir);
            this.Controls.Add(this.btnLimpar);
            this.Controls.Add(this.btnSair);
            this.Controls.Add(this.minhaLabel);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label minhaLabel;
        private System.Windows.Forms.Button btnSair;
        private System.Windows.Forms.Button btnLimpar;
        private System.Windows.Forms.Button btnExibir;
        private System.Windows.Forms.Button btnExe1;
        private System.Windows.Forms.Button btnExe2;
        private System.Windows.Forms.Button btnExe3;
    }
}

