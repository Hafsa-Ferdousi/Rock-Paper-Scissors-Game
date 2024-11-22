
package rockpaperscissorsgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class RockPaperScissorsGame {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Rock Paper Scissors Game ");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,400);
        frame.getContentPane().setBackground(Color.magenta);
        frame.setLayout(new BorderLayout());
        
        JLabel resultLabel= new JLabel("Choose Rock , Paper, or  Scissiors" ,SwingConstants.CENTER);
         resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
         frame.add(resultLabel, BorderLayout.NORTH);
         
         
         //button
         JButton rockButton = new JButton("Rock");
         JButton paperButton = new JButton("Paper");
         JButton scissorsButton = new JButton("Scissors");
         

          
          //panel for button
         
         JPanel buttonPanel = new JPanel();
         buttonPanel.add(rockButton);
         buttonPanel.add(paperButton);
         buttonPanel.add(scissorsButton);
          frame.add(buttonPanel, BorderLayout.CENTER);
          
          
         //Label to show the coputer choice
         JLabel computerChoiceLabel = new JLabel ("Computer Choice: ",SwingConstants.CENTER);
          frame.add(computerChoiceLabel, BorderLayout.SOUTH);
          
        ActionListener buttonListener =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String userChoice = e.getActionCommand();
              String[] choices ={"Rock", "Paper", "Scissors"};
              Random random =new Random();
              String computerChoice = choices [random.nextInt(3)];
            
           String result;
           if (userChoice.equals(computerChoice)){
               result = "It's a tie!";
               
           }else if ((userChoice.equals("Rock")&& computerChoice.equals("Scissors"))||
                     (userChoice.equals("Paper")&& computerChoice.equals("Rock"))||
                     (userChoice.equals("Scissors")&& computerChoice.equals("Paper"))){
               result ="You Win!";
           }else{
               result ="You lose!";
           }
             
           
           //update the labels
           computerChoiceLabel.setText("Computer's choice: "+ computerChoice );
           resultLabel.setText(result);
           
              
             }
             
         };
        
        //attach the action lisetener to buttons
        
        rockButton.addActionListener(buttonListener);
        paperButton.addActionListener(buttonListener);
        scissorsButton.addActionListener(buttonListener); 
        frame.setVisible(true);
    }
    
}
