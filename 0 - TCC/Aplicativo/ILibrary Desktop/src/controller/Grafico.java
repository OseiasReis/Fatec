package controller;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class Grafico extends JFrame {

	public Grafico(double[] valores, String ano) {

		super("..::     ILibrary Administrador - Gráfico Anual     ::..");

		setVisible(true);
		setSize(900, 500);
		setLocationRelativeTo(null);
		CategoryDataset dataset = createDataset(valores);
		JFreeChart chart = createChart(dataset, ano);
		ChartPanel chartPanel = new ChartPanel(chart);
		setContentPane(chartPanel);
		
		ImageIcon icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
	}

	private static CategoryDataset createDataset(double[] valores) {

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(valores[0], "", "Jan");
		dataset.addValue(valores[1], "", "Fev");
		dataset.addValue(valores[2], "", "Mar");
		dataset.addValue(valores[3], "", "Abr");
		dataset.addValue(valores[4], "", "Mai");
		dataset.addValue(valores[5], "", "Jun");
		dataset.addValue(valores[6], "", "Jul");
		dataset.addValue(valores[7], "", "Ago");
		dataset.addValue(valores[8], "", "Set");
		dataset.addValue(valores[9], "", "Out");
		dataset.addValue(valores[10], "", "Nov");
		dataset.addValue(valores[11], "", "Dez");
		return dataset;

	}

	private static JFreeChart createChart(final CategoryDataset dataset, String ano) {

		final JFreeChart chart = ChartFactory.createBarChart3D("Empréstimo Anual (" + ano + ")", "Meses", "Emprestimo",
				dataset, PlotOrientation.VERTICAL, false, true, false);

		chart.setBackgroundPaint(Color.WHITE);

		CategoryPlot plot = chart.getCategoryPlot();

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		renderer.setSeriesPaint(0, new Color(0, 120, 255));
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);

		return chart;

	}
}
