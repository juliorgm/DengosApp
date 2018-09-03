package br.com.juliorgm.dengosapp.helper;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

import br.com.juliorgm.dengosapp.MainActivity;
import br.com.juliorgm.dengosapp.R;

public class HelperQuestion {

    private MainActivity mainActivity;

    private RadioButton radioButton;
    private String msgErro;

    private EditText editQuestion1;
    private RadioGroup rdgQuestion2, rdgQuestion3,rdgQuestion4,rdgQuestion6,rdgQuestion7,rdgQuestion8,rdgQuestion10;
    private CheckBox cbxQuestion5A,cbxQuestion5B,cbxQuestion5C,cbxQuestion5D,cbxQuestion9A,cbxQuestion9B,cbxQuestion9C;
    private TextView txtAnswer1,txtAnswer2,txtAnswer3,txtAnswer4,txtAnswer5,txtAnswer6,txtAnswer7,txtAnswer8,txtAnswer9,txtAnswer10,txtFinalResult;

    private RadioButton rbQuestion2Femea,rbQuestion3A,rbQuestion4A,rbQuestion6D,rbQuestion7A,rbQuestion8A,rbQuestion10D;
    private Button btnAnswer;

    private int result=0;


    public HelperQuestion(MainActivity activity) {
        this.editQuestion1 = activity.findViewById(R.id.editQuestion1);
        this.rdgQuestion2 = activity.findViewById(R.id.rdgQuestion2);
        this.rdgQuestion3 = activity.findViewById(R.id.rdgQuestion3);
        this.rdgQuestion4 = activity.findViewById(R.id.rdgQuestion4);
        this.rdgQuestion6 = activity.findViewById(R.id.rdgQuestion6);
        this.rdgQuestion7 = activity.findViewById(R.id.rdgQuestion7);
        this.rdgQuestion8 = activity.findViewById(R.id.rdgQuestion8);
        this.rdgQuestion10 = activity.findViewById(R.id.rdgQuestion10);

        this.cbxQuestion5A = activity.findViewById(R.id.cbxQuestion5A);
        this.cbxQuestion5B = activity.findViewById(R.id.cbxQuestion5B);
        this.cbxQuestion5C = activity.findViewById(R.id.cbxQuestion5C);
        this.cbxQuestion5D = activity.findViewById(R.id.cbxQuestion5D);

        this.cbxQuestion9A = activity.findViewById(R.id.cbxQuestion9A);
        this.cbxQuestion9B = activity.findViewById(R.id.cbxQuestion9B);
        this.cbxQuestion9C = activity.findViewById(R.id.cbxQuestion9C);

        this.txtAnswer1 = activity.findViewById(R.id.txtAnswer1);
        this.txtAnswer2 = activity.findViewById(R.id.txtAnswer2);
        this.txtAnswer3 = activity.findViewById(R.id.txtAnswer3);
        this.txtAnswer4 = activity.findViewById(R.id.txtAnswer4);
        this.txtAnswer5 = activity.findViewById(R.id.txtAnswer5);
        this.txtAnswer6 = activity.findViewById(R.id.txtAnswer6);
        this.txtAnswer7 = activity.findViewById(R.id.txtAnswer7);
        this.txtAnswer8 = activity.findViewById(R.id.txtAnswer8);
        this.txtAnswer9 = activity.findViewById(R.id.txtAnswer9);
        this.txtAnswer10 = activity.findViewById(R.id.txtAnswer10);
        this.txtFinalResult = activity.findViewById(R.id.txtFinalResult);

        this.rbQuestion2Femea = activity.findViewById(R.id.rbQuestion2Femea);
        this.rbQuestion3A = activity.findViewById(R.id.rbQuestion3A);
        this.rbQuestion4A = activity.findViewById(R.id.rbQuestion4A);
        this.rbQuestion6D = activity.findViewById(R.id.rbQuestion6D);
        this.rbQuestion7A = activity.findViewById(R.id.rbQuestion7A);
        this.rbQuestion8A = activity.findViewById(R.id.rbQuestion8A);
        this.rbQuestion10D = activity.findViewById(R.id.rbQuestion10D);
        this.btnAnswer = activity.findViewById(R.id.btnAnswer);

    }

    public void sendQuestions(){
        if(validateQuestions()){
            verifyAnswerQuestions();
            mainMessage("Você acertou " + result + " de 10 questões");
            btnAnswer.setText("Voltar");
            result=0;
        }else {
            mainMessage("Verifique as questões que ainda não foram respondidas");
        }
    }

    void mainMessage(String msg){
        txtFinalResult.setEnabled(true);
        txtFinalResult.setVisibility(View.VISIBLE);
        txtFinalResult.setText(msg);
        txtFinalResult.setFocusable(true);
        result = 0;
    }

    public void verifyAnswerQuestions(){

        if (answerQuestion1())  result++;
        if (answerQuestion2())  result++;
        if (answerQuestion3())  result++;
        if (answerQuestion4())  result++;
        if (answerQuestion5())  result++;
        if (answerQuestion6())  result++;
        if (answerQuestion7())  result++;
        if (answerQuestion8())  result++;
        if (answerQuestion9())  result++;
        if (answerQuestion10()) result++;
    }
    public boolean validateQuestions(){
        boolean bool = true;
        if (!validateQuestion1())  bool = false;
        if (!validateQuestion2())  bool = false;
        if (!validateQuestion3())  bool = false;
        if (!validateQuestion4())  bool = false;
        if (!validateQuestion5())  bool = false;
        if (!validateQuestion6())  bool = false;
        if (!validateQuestion7())  bool = false;
        if (!validateQuestion8())  bool = false;
        if (!validateQuestion9())  bool = false;
        if (!validateQuestion10()) bool = false;
        return bool;
    }




    public boolean validateQuestion1(){
        String res = editQuestion1.getText().toString().trim();
        if (res.equals("")|| res.isEmpty()) {
            txtAnswer1.setText("Você precisa preencher este campo");
            editQuestion1.setFocusable(true);
            return false;
        }

       return true;

    }

    boolean answerQuestion1(){
        String res = editQuestion1.getText().toString().trim();
        if (res.equals("Aedes Aegypti")) {
            messageCorrectAnswer(txtAnswer1);
            return true;
        }
        else{
            txtAnswer1.setText("Errado: o nome do mosquito que transmite a dengue é Aedes Aegypti");
            return false;
        }
    }

    public boolean validateQuestion2() {return validaRadio(rdgQuestion2,txtAnswer2);}
    public boolean validateQuestion3() {return validaRadio(rdgQuestion3,txtAnswer3);}
    public boolean validateQuestion4() {return validaRadio(rdgQuestion4,txtAnswer4);}
    public boolean validateQuestion6() {return validaRadio(rdgQuestion6,txtAnswer6);}
    public boolean validateQuestion7() {return validaRadio(rdgQuestion7,txtAnswer7);}
    public boolean validateQuestion8() {return validaRadio(rdgQuestion8,txtAnswer8);}
    public boolean validateQuestion10() {return validaRadio(rdgQuestion10,txtAnswer10);}

    public boolean answerQuestion2() {return  answerRadio(rdgQuestion2,txtAnswer2,"Apenas as fêmeas transmitem o vírus",rbQuestion2Femea);}
    public boolean answerQuestion3() {return  answerRadio(rdgQuestion3,txtAnswer3,"O mosquito pica o doente e transmite a dengue para outras pessoas",rbQuestion3A);}
    public boolean answerQuestion4() {return  answerRadio(rdgQuestion4,txtAnswer4,"O vírus da dengue atinge somente primatas",rbQuestion4A);  }
    public boolean answerQuestion6() {return  answerRadio(rdgQuestion6,txtAnswer6,"Racionamento de água não faz parte das ações de prevenção da dengue",rbQuestion6D);  }
    public boolean answerQuestion7() {return  answerRadio(rdgQuestion7,txtAnswer7,"O lixo deve ser jogado somente na lixeira",rbQuestion7A);  }
    public boolean answerQuestion8() {return  answerRadio(rdgQuestion8,txtAnswer8,"A água deve ser trocada diariamente    ",rbQuestion8A);  }
    public boolean answerQuestion10() {return answerRadio(rdgQuestion10,txtAnswer10,"A dengue é responsabilidade de todos",rbQuestion10D);  }

    public boolean validaRadio(RadioGroup radioGroup,TextView textResposta) {
        int position = radioGroup.getCheckedRadioButtonId();

        if(position==-1){
            textResposta.setText("Você precisa esolher uma das alternativas acima");
            textResposta.setFocusable(true);
            return false;
        }
        return true;
    }


    private boolean answerRadio(RadioGroup radioGroup, TextView textResposta, String resposta,RadioButton radio) {
        int position = radioGroup.getCheckedRadioButtonId();

        if(position==radio.getId()){
            messageCorrectAnswer(textResposta);
            return true;
        }else
            textResposta.setText(resposta);

        return false;
    }

    void messageCorrectAnswer(TextView t){
        t.setText("Correto");
        //t.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorPrimaryDark));
    }


    private boolean validateQuestion5() {
        String answer = "";

        if(!cbxQuestion5A.isChecked() && !cbxQuestion5B.isChecked() && !cbxQuestion5C.isChecked() &&!cbxQuestion5D.isChecked()) {
            answer="Você precisa escolher pelo menos uma das alternativas";
            return false;
        }
        return true;
    }

    private boolean answerQuestion5(){
        String answer = "";
        if(cbxQuestion5A.isChecked() && !cbxQuestion5B.isChecked() && cbxQuestion5C.isChecked() &&!cbxQuestion5D.isChecked()){
            answer="Certo: Alguns dos sintomas da dengue são frebre alta, mal estar, dor de cabeça e na região dos olhos";
            return true;
        }else
            answer="Errado:Os sintomas da dengue são frebre alta, mal estar, dor de cabeça e na região dos olhos";
            txtAnswer5.setText(answer);
            return false;
    }

    private boolean validateQuestion9() {
        if(!cbxQuestion9A.isChecked()&& !cbxQuestion9B.isChecked()&&!cbxQuestion9C.isChecked()) {
            txtAnswer9.setText(" Você precisa esolher uma das alternativas acima");
            txtAnswer9.setFocusable(true);
            return false;
        }
        return true;
    }

    private boolean answerQuestion9() {
      if(cbxQuestion9A.isChecked()&& cbxQuestion9B.isChecked()&&cbxQuestion9C.isChecked()){
            txtAnswer9.setText("Todas as alteranativas estão corretas");
            return true;
        }else
            txtAnswer9.setText("Todas as alteranativas estão corretas");
        return false;
    }


    public boolean turnBack() {
        if(btnAnswer.getText().toString().equals("Voltar")) return true;
        return false;
    }
}
