package br.com.juliorgm.dengosapp.helper;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.juliorgm.dengosapp.MainActivity;
import br.com.juliorgm.dengosapp.R;

public class HelperQuestion {

    private Context mContext;
    private RadioButton radioButton;
    private String msgErro;

    private EditText mEditQuestion1;
    private RadioGroup mRdgQuestion2, mRdgQuestion3, mRdgQuestion4, mRdgQuestion6, mRdgQuestion7, mRdgQuestion8, mRdgQuestion10;
    private CheckBox mCbxQuestion5A, mCbxQuestion5B, mCbxQuestion5C, mCbxQuestion5D, mCbxQuestion9A, mCbxQuestion9B, mCbxQuestion9C;
    private TextView mTxtAnswer1, mTxtAnswer2, mTxtAnswer3, mTxtAnswer4, mTxtAnswer5, mTxtAnswer6, mTxtAnswer7, mTxtAnswer8, mTxtAnswer9, mTxtAnswer10, mTxtFinalResult;

    private RadioButton mRbQuestion2Femea, mRbQuestion3A, mRbQuestion4A, mRbQuestion6D, mRbQuestion7A, mRbQuestion8A, mRbQuestion10D;
    private Button mBtnAnswer;

    private int mResult = 0;

    public HelperQuestion(MainActivity activity) {

        this.mContext = activity.getApplicationContext();

        this.mEditQuestion1 = activity.findViewById(R.id.editQuestion1);
        this.mRdgQuestion2 = activity.findViewById(R.id.rdgQuestion2);
        this.mRdgQuestion3 = activity.findViewById(R.id.rdgQuestion3);
        this.mRdgQuestion4 = activity.findViewById(R.id.rdgQuestion4);
        this.mRdgQuestion6 = activity.findViewById(R.id.rdgQuestion6);
        this.mRdgQuestion7 = activity.findViewById(R.id.rdgQuestion7);
        this.mRdgQuestion8 = activity.findViewById(R.id.rdgQuestion8);
        this.mRdgQuestion10 = activity.findViewById(R.id.rdgQuestion10);

        this.mCbxQuestion5A = activity.findViewById(R.id.cbxQuestion5A);
        this.mCbxQuestion5B = activity.findViewById(R.id.cbxQuestion5B);
        this.mCbxQuestion5C = activity.findViewById(R.id.cbxQuestion5C);
        this.mCbxQuestion5D = activity.findViewById(R.id.cbxQuestion5D);

        this.mCbxQuestion9A = activity.findViewById(R.id.cbxQuestion9A);
        this.mCbxQuestion9B = activity.findViewById(R.id.cbxQuestion9B);
        this.mCbxQuestion9C = activity.findViewById(R.id.cbxQuestion9C);

        this.mTxtAnswer1 = activity.findViewById(R.id.txtAnswer1);
        this.mTxtAnswer2 = activity.findViewById(R.id.txtAnswer2);
        this.mTxtAnswer3 = activity.findViewById(R.id.txtAnswer3);
        this.mTxtAnswer4 = activity.findViewById(R.id.txtAnswer4);
        this.mTxtAnswer5 = activity.findViewById(R.id.txtAnswer5);
        this.mTxtAnswer6 = activity.findViewById(R.id.txtAnswer6);
        this.mTxtAnswer7 = activity.findViewById(R.id.txtAnswer7);
        this.mTxtAnswer8 = activity.findViewById(R.id.txtAnswer8);
        this.mTxtAnswer9 = activity.findViewById(R.id.txtAnswer9);
        this.mTxtAnswer10 = activity.findViewById(R.id.txtAnswer10);
        this.mTxtFinalResult = activity.findViewById(R.id.txtFinalResult);

        this.mRbQuestion2Femea = activity.findViewById(R.id.rbQuestion2Femea);
        this.mRbQuestion3A = activity.findViewById(R.id.rbQuestion3A);
        this.mRbQuestion4A = activity.findViewById(R.id.rbQuestion4A);
        this.mRbQuestion6D = activity.findViewById(R.id.rbQuestion6D);
        this.mRbQuestion7A = activity.findViewById(R.id.rbQuestion7A);
        this.mRbQuestion8A = activity.findViewById(R.id.rbQuestion8A);
        this.mRbQuestion10D = activity.findViewById(R.id.rbQuestion10D);
        this.mBtnAnswer = activity.findViewById(R.id.btnAnswer);
    }

    public void sendQuestions() {
        if (validateQuestions()) {
            verifyAnswerQuestions();

            String msgResult = mContext.getString(R.string.context_acerto) + mResult + mContext.getString(R.string.context_total_questoes);
            mainMessage(msgResult);
            msgAlert(msgResult);
            mBtnAnswer.setText(mContext.getString(R.string.context_voltar));
            mResult = 0;
        } else {
            mainMessage(mContext.getString(R.string.context_falta_responder));
            msgAlert(mContext.getString(R.string.context_falta_responder));
        }
    }

    private void mainMessage(String msg) {
        mTxtFinalResult.setEnabled(true);
        mTxtFinalResult.setVisibility(View.VISIBLE);
        mTxtFinalResult.setText(msg);
        mTxtFinalResult.setFocusable(true);
        mResult = 0;
    }

    private void verifyAnswerQuestions() {

        if (answerQuestion1()) mResult++;
        if (answerQuestion2()) mResult++;
        if (answerQuestion3()) mResult++;
        if (answerQuestion4()) mResult++;
        if (answerQuestion5()) mResult++;
        if (answerQuestion6()) mResult++;
        if (answerQuestion7()) mResult++;
        if (answerQuestion8()) mResult++;
        if (answerQuestion9()) mResult++;
        if (answerQuestion10()) mResult++;
    }

    private boolean validateQuestions() {
        boolean bool = true;
        if (!validateQuestion1()) bool = false;
        if (!validateQuestion2()) bool = false;
        if (!validateQuestion3()) bool = false;
        if (!validateQuestion4()) bool = false;
        if (!validateQuestion5()) bool = false;
        if (!validateQuestion6()) bool = false;
        if (!validateQuestion7()) bool = false;
        if (!validateQuestion8()) bool = false;
        if (!validateQuestion9()) bool = false;
        if (!validateQuestion10()) bool = false;
        return bool;
    }

    private boolean validateQuestion1() {
        String res = mEditQuestion1.getText().toString().trim();
        if (res.equals("") || res.isEmpty()) {
            mTxtAnswer1.setText(mContext.getString(R.string.context_obrigatorio));
            mEditQuestion1.setFocusable(true);
            return false;
        }
        return true;
    }

    private boolean answerQuestion1() {
        String res = mEditQuestion1.getText().toString().trim().toLowerCase();
        if (res.equals(mContext.getString(R.string.context_aedes_aegypti))) {
            messageCorrectAnswer(mTxtAnswer1);
            return true;
        } else {
            mTxtAnswer1.setText(mContext.getString(R.string.context_erro_q1));
            return false;
        }
    }

    private boolean validateQuestion2() {
        return validaRadio(mRdgQuestion2, mTxtAnswer2);
    }

    private boolean validateQuestion3() {
        return validaRadio(mRdgQuestion3, mTxtAnswer3);
    }

    private boolean validateQuestion4() {
        return validaRadio(mRdgQuestion4, mTxtAnswer4);
    }

    private boolean validateQuestion6() {
        return validaRadio(mRdgQuestion6, mTxtAnswer6);
    }

    private boolean validateQuestion7() {
        return validaRadio(mRdgQuestion7, mTxtAnswer7);
    }

    private boolean validateQuestion8() {
        return validaRadio(mRdgQuestion8, mTxtAnswer8);
    }

    private boolean validateQuestion10() {
        return validaRadio(mRdgQuestion10, mTxtAnswer10);
    }

    private boolean answerQuestion2() {
        return answerRadio(mRdgQuestion2, mTxtAnswer2, mContext.getString(R.string.context_errada_q2), mRbQuestion2Femea);
    }

    private boolean answerQuestion3() {
        return answerRadio(mRdgQuestion3, mTxtAnswer3, mContext.getString(R.string.context_errada_q3), mRbQuestion3A);
    }

    private boolean answerQuestion4() {
        return answerRadio(mRdgQuestion4, mTxtAnswer4, mContext.getString(R.string.context_errada_q4), mRbQuestion4A);
    }

    private boolean answerQuestion6() {
        return answerRadio(mRdgQuestion6, mTxtAnswer6, mContext.getString(R.string.context_errada_q6), mRbQuestion6D);
    }

    private boolean answerQuestion7() {
        return answerRadio(mRdgQuestion7, mTxtAnswer7, mContext.getString(R.string.context_errada_q7), mRbQuestion7A);
    }

    private boolean answerQuestion8() {
        return answerRadio(mRdgQuestion8, mTxtAnswer8,mContext.getString(R.string.context_errada_q8), mRbQuestion8A);
    }

    private boolean answerQuestion10() {
        return answerRadio(mRdgQuestion10, mTxtAnswer10, mContext.getString(R.string.context_errada_q10), mRbQuestion10D);
    }

    private boolean validaRadio(RadioGroup radioGroup, TextView textResposta) {
        int position = radioGroup.getCheckedRadioButtonId();

        if (position == -1) {
            textResposta.setText(mContext.getString(R.string.context_cbx_obrigatorio));
            textResposta.setFocusable(true);
            return false;
        }
        return true;
    }

    private boolean answerRadio(RadioGroup radioGroup, TextView textResposta, String resposta, RadioButton radio) {
        int position = radioGroup.getCheckedRadioButtonId();

        if (position == radio.getId()) {
            messageCorrectAnswer(textResposta);
            return true;
        } else
            textResposta.setText(resposta);

        return false;
    }

    private void messageCorrectAnswer(TextView t) {
        t.setText(mContext.getString(R.string.context_correto));
    }

    private boolean validateQuestion5() {
         if (!mCbxQuestion5A.isChecked() && !mCbxQuestion5B.isChecked() && !mCbxQuestion5C.isChecked() && !mCbxQuestion5D.isChecked()) {
             mTxtAnswer5.setText(mContext.getString(R.string.context_valida_q5));
            return false;
         }
        return true;
    }

    private boolean answerQuestion5() {
        String answer;
        boolean bool = false;
        if (mCbxQuestion5A.isChecked() && mCbxQuestion5C.isChecked()&& !mCbxQuestion5B.isChecked()&& !mCbxQuestion5D.isChecked()) {
            answer =  mContext.getString(R.string.context_certa_q5);
            bool = true;
        } else
            answer = mContext.getString(R.string.context_errada_q5);

        mTxtAnswer5.setText(answer);
        return bool;
    }

    private boolean validateQuestion9() {
        if (!mCbxQuestion9A.isChecked() && !mCbxQuestion9B.isChecked() && !mCbxQuestion9C.isChecked()) {
            mTxtAnswer9.setText(mContext.getString(R.string.context_cbx_obrigatorio));
            mTxtAnswer9.setFocusable(true);
            return false;
        }
        return true;
    }

    private void msgAlert(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    private boolean answerQuestion9() {
        if (mCbxQuestion9A.isChecked() && mCbxQuestion9B.isChecked() && mCbxQuestion9C.isChecked()) {
            mTxtAnswer9.setText(mContext.getString(R.string.context_certa_q9));
            return true;
        } else
            mTxtAnswer9.setText(mContext.getString(R.string.context_errada_q9));
        return false;
    }

    public boolean turnBack() {
        return mBtnAnswer.getText().toString().equals(mContext.getString(R.string.context_voltar));
    }
}
