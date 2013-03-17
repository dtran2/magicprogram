package edu.ycp.cs320.magicprogram.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.magicprogram.shared.*;
//import com.google.gwt.user.client.ui.TreeImages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MagicprogramUI implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	
	private Game game;
	private GameView gameView;
	private RootPanel rootPanel;
	private FlowPanel flowPanel;
	private Canvas canvas;
	private Context2d context;
	private Button btnAddCreepTo;
	/**
	 * @wbp.nonvisual location=118,99
	 */
	
	public MagicprogramUI() {
		
	}
	
	public void onModuleLoad() {
		game = new Game();
		gameView = new GameView();
		gameView.setModel(game);
	    rootPanel = RootPanel.get();
	    rootPanel.setSize("700px", "500px");
	    
	    flowPanel = new FlowPanel();
	    rootPanel.add(flowPanel, 0, 0);
	    flowPanel.setSize("700px", "500px");
	    
	    canvas = Canvas.createIfSupported();
	    canvas.setCoordinateSpaceWidth(400);
	    canvas.setCoordinateSpaceHeight(400);
	    
	    flowPanel.add(canvas);
	    canvas.setSize("400px", "400px");
	    
	    btnAddCreepTo = new Button("Send Creep");
	    btnAddCreepTo.addClickHandler(new ClickHandler() {
	    	public void onClick(ClickEvent event) {
	    		game.getCreeps().add(new Creep(new Point(), game.getWaypoints()));
	    	}
	    });
	    flowPanel.add(btnAddCreepTo);
	    
	    context = canvas.getContext2d();
	    
	    // setup timer
	    Timer timer = new Timer() {
	      @Override
	      public void run() {
	    	  game.update();
	    	  context.beginPath();
	    	  context.setFillStyle(CssColor.make("white"));
	    	  context.fillRect(0, 0, 400, 400);
	    	  context.setFillStyle(CssColor.make("red"));
	    	  for (Creep creep : game.getCreeps()) {
	    		  context.fillRect(creep.getPos().getX(), creep.getPos().getY(), creep.getSize(), creep.getSize());
	    	  }
	    	  context.closePath();
	      }
	    };
	    timer.scheduleRepeating(25);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
//		rootLayoutPanel.add(panel);
//		RootLayoutPanel.get().setWidgetLeftRight(panel, 10.0, Unit.PX, 10.0, Unit.PX);
//		RootLayoutPanel.get().setWidgetTopBottom(panel, 10.0, Unit.PX, 10.0, Unit.PX);
//		
//		Button creepButton = new Button("add creep");
//		creepButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				game.addCreep();
//			}
//		});
//		panel.add(creepButton);
//		panel.setWidgetLeftWidth(creepButton, 325.0, Unit.PX, 81.0, Unit.PX);
//		panel.setWidgetTopHeight(creepButton, 52.0, Unit.PX, 30.0, Unit.PX);
	}
}
