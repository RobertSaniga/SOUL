package cz.saniga.android.diploma.soul.model.components;

import org.simpleframework.xml.Attribute;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;

public class Choice extends LinearLayout {

	@Attribute
	private String label;

	private TextView labelView;

	public Choice(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.choice_horizontal, null);
		labelView.setText(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
