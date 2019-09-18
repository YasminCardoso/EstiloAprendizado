package com.ppa.perfildeaprendizado;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class QuestionarioActivity extends AppCompatActivity {

    public static boolean refazer = false;
    private TextView questao;
    private static ProgressBar progressBar;
    public static int numQuestao = 0;
    public Integer[] numQuestoesSpinner;
    private RadioButton radioDiscTot;
    private RadioButton radioDisc;
    private RadioButton radioConc;
    private RadioButton radioConcTot;
    private Spinner comboQuestoes;
    private String[] questoes = new String[]{"Eu tenho fama de dizer o que penso claramente e sem rodeios."
            , "Tenho certeza do que é bom e do que é mau, do que está certo e do que está errado."
            , "Muitas vezes ajo sem olhar as consequências."
            , "Geralmente, resolvo os problemas de forma metódica, passo a passo."
            , "Acho que a formalidade limita a espontaneidade das pessoas."
            , "Tenho interesse em saber quais são os princípios das pessoas e com quais critérios elas agem."
            , "Acho que agir de forma espontânea pode ser tão valioso quanto agir de forma ponderada."
            , "Eu acho que o mais importante é que as coisas funcionem."
            , "Presto atenção em todos os detalhes das disciplinas que frequento."
            , "Fico satisfeito(a) quando tenho tempo para organizar meu estudo e realizá-lo de forma consciente."
            , "Sou adepto(a) da autodisciplina, eu sigo uma certa ordem, por exemplo, na alimentação, no estudo e ao praticar exercícios físicos."
            , "Quando escuto uma nova ideia, em seguida, começo a pensar em como colocá-la em prática."
            , "Prefiro as ideias originais e novas mesmo que não sejam práticas."
            , "Aceito e sigo as normas somente se servem para atingir meus objetivos."
            , "Normalmente me dou bem com pessoas pensativas (reflexivas), e acho difícil me entrosar com pessoas extremamente espontâneas e imprevisíveis."
            , "Escuto com mais frequência do que falo."
            , "Prefiro as coisas organizadas do que as desordenadas."
            , "Quando possuo alguma informação, analiso-a bem antes de expressar qualquer ideia."
            , "Antes de fazer algo, estudo cuidadosamente as vantagens e as desvantagens."
            , "Fico entusiasmado(a) quando faço algo novo e diferente."
            , "Quase sempre procuro ser coerente com meus critérios e valores. Tenho princípios e os respeito."
            , "Em uma discussão, não gosto de rodeios."
            , "Não gosto do envolvimento afetivo no ambiente de estudo. Prefiro manter o relacionamento distante."
            , "Gosto mais das pessoas realistas e concretas do que as teóricas."
            , "Tenho dificuldade em ser criativo(a) e em superar as estruturas."
            , "Gosto de ficar perto de pessoas espontâneas e divertidas."
            , "Na maioria das vezes, demonstro abertamente o que sinto."
            , "Gosto de analisar e transformar as coisas."
            , "Fico incomodado(a) quando as pessoas não levam as coisas a sério."
            , "Fico tentado(a) em experimentar e praticar as últimas técnicas e inovações."
            , "Sou cauteloso(a) na hora de tirar conclusões."
            , "Prefiro ter o maior número de fontes de informação. Quanto mais dados tiver reunido para refletir, melhor."
            , "Tenho tendência a ser perfeccionista (detalhista)."
            , "Prefiro ouvir a opinião dos outros antes de expor a minha."
            , "Gosto de levar a vida espontaneamente e não ter que planejar tudo com antecedência."
            , "Nas discussões gosto de observar como os outros participantes se comportam."
            , "Fico incomodado(a) com as pessoas caladas e excessivamente cuidadosas."
            , "Muitas vezes, julgo as ideias dos outros pelo valor prático."
            , "Fico angustiado(a) quando me obrigam a acelerar uma tarefa para cumprir o prazo."
            , "Nos trabalhos em grupo, apoio as ideias práticas e realistas."
            , "É melhor aproveitar o momento presente do que ficar pensando no passado ou no futuro."
            , "Fico incomodado(a) com as pessoas que sempre desejam apressar as coisas."
            , "Apoio ideias novas e espontâneas nos trabalhos em grupo."
            , "Eu acho que as decisões fundamentadas numa análise cuidadosa são mais consistentes do que as baseadas na intuição."
            , "Percebo frequentemente a contradição e os pontos frágeis nas argumentações dos outros."
            , "Eu acho que é necessário passar por cima das normas muito mais vezes do que cumpri-las."
            , "Geralmente, percebo formas melhores e mais práticas de fazer as coisas."
            , "Geralmente, falo mais do que escuto."
            , "Prefiro ficar distante dos fatos e observá-los a partir de outra perspectiva."
            , "Estou convencido(a) de que a lógica e a razão devem ser impostas."
            , "Gosto de buscar novas experiências."
            , "Gosto de experimentar e aplicar as coisas."
            , "Eu acho que devemos chegar logo ao centro das questões e não ficar enrolando."
            , "Procuro sempre chegar a conclusões e ideias claras."
            , "Prefiro discutir questões concretas e não perder tempo com discursos vazios."
            , "Fico impaciente quando me dão explicações desnecessárias e contraditórias."
            , "Comprovo antes se as coisas realmente funcionam."
            , "Faço vários rascunhos antes da redação final de um trabalho."
            , "Tenho certeza que nas discussões ajudo os outros a ficarem focados no tema, evitando distrações."
            , "Normalmente, numa discussão em grupo, percebo que sou um(a) dos(as) mais objetivos(as) e sensatos(as)."
            , "Quando algo dá errado, não dou importância e tento fazer melhor."
            , "Eu dispenso as ideias originais e espontâneas se elas não forem práticas."
            , "Gosto de comparar várias alternativas antes de tomar uma decisão."
            , "Frequentemente, olho adiante para prever o futuro."
            , "Nos debates e discussões prefiro desempenhar um papel secundário do que ser o(a) líder ou aquele(a) que mais participa."
            , "Fico incomodado(a) com as pessoas que não agem com lógica."
            , "Eu não gosto muito ter que planejar e prever as coisas."
            , "Em muitos casos, eu acho que os fins justificam os meios."
            , "Costumo refletir sobre os assuntos e problemas."
            , "Quando estudo de forma consciente,  fico satisfeito(a) e sinto orgulho."
            , "Diante dos acontecimentos, procuro descobrir quais são os princípios e as teorias nas quais eles se baseiam."
            , "Para alcançar o meu objetivo, sou capaz de ferir os sentimentos dos outros."
            , "Não me importo em fazer tudo o que é necessário para tornar meu trabalho (estudo) eficiente."
            , "Normalmente, sou aquela pessoa que mais anima as festas."
            , "Fico rapidamente aborrecido(a) com o trabalho detalhista e cuidadoso."
            , "Na maioria das vezes, as pessoas acham que sou insensível em relação aos sentimentos delas."
            , "Geralmente, minhas intuições me orientam (guiam)."
            , "Se faço parte de um trabalho em grupo, tento seguir um plano, uma ordem, uma metodologia.."
            , "Normalmente, fico interessado(a) em descobrir o que as pessoas pensam.."
            , "Evito os assuntos abstratos, duvidosos e pouco claros."};;
    private static Integer[] respostas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionario);

        this.respostas = new Integer[this.questoes.length];
        this.numQuestao = 0;
        this.radioDiscTot = findViewById(R.id.radioDiscTot);
        this.radioDisc = findViewById(R.id.radioDisc);
        this.radioConc = findViewById(R.id.radioConc);
        this.radioConcTot = findViewById(R.id.radioConcTot);
        numQuestoesSpinner = new Integer[this.questoes.length];
        for(int i = 1; i <= questoes.length; i++){
            numQuestoesSpinner[i-1] = i;
        }

        System.out.println(numQuestoesSpinner[79]);

        radioDiscTot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radioDiscTot.setChecked(false);
                System.out.println("numQuestao:"+numQuestao);
                respostas[numQuestao] = 0;
                while(respostas.length > numQuestao && respostas[numQuestao] != null){
                    numQuestao++;

                }



                System.out.println(respostas);
                avancaPergunta();
            }
        });

        radioDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioDisc.setChecked(false);
                System.out.println("numQuestao:"+numQuestao);
                respostas[numQuestao] = 1;
                while(respostas.length > numQuestao && respostas[numQuestao] != null){
                    numQuestao++;

                }

                System.out.println(respostas);
                avancaPergunta();
            }
        });

        radioConc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioConc.setChecked(false);
                System.out.println("numQuestao:"+numQuestao);
                respostas[numQuestao] = 2;
                while(respostas.length > numQuestao && respostas[numQuestao] != null){
                    numQuestao++;

                }

                System.out.println(respostas);
                avancaPergunta();

            }
        });

        radioConcTot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioConcTot.setChecked(false);
                System.out.println("numQuestao:"+numQuestao);
                respostas[numQuestao] = 3;
                while(respostas.length > numQuestao && respostas[numQuestao] != null){
                    numQuestao++;

                }

                System.out.println(respostas);
                avancaPergunta();


            }
        });


        progressBar = (ProgressBar) findViewById(R.id.progressBarQuest);
        progressBar.setMax(questoes.length);
        progressBar.setProgress(numQuestao);

        avancaPergunta();

        comboQuestoes = (Spinner) findViewById(R.id.spinnerQuestao);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, numQuestoesSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboQuestoes.setAdapter(adapter);

        comboQuestoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                questao = (TextView) findViewById(R.id.pergunta);
                numQuestao = position;
                questao.setText(questoes[numQuestao]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    public String[] getQuestoes(){
        return this.questoes;
    }

    public void avancaPergunta(){

        if(this.refazer == true){
            this.numQuestao = 0;
            this.refazer = false;
            System.out.println("NUMERO QUESTAO="+this.numQuestao);
        }
        Integer count = 0;
        for(int i = 0; i < questoes.length; i++){
            if(respostas[i] != null){
                count++;
            }
        }
        System.out.println("progress: "+count);
        progressBar.setProgress(count);

        if(this.numQuestao < this.questoes.length){
            questao = (TextView) findViewById(R.id.pergunta);
            questao.setText(questoes[numQuestao]);

        } else {
            if(count != questoes.length){
                int contador = 0;
                for(int i = 0; i < questoes.length; i++){
                    if(respostas[i] != null){
                        contador++;
                    } else {
                        break;
                    }
                }
                numQuestao = contador;
            } else {
                this.numQuestao = 0;
                terminaQuestionario();
            }
        }

        Spinner s = (Spinner) findViewById(R.id.spinnerQuestao);
        s.setSelection(this.numQuestao);






    }

    public void terminaQuestionario(){

        Intent intent = new Intent(QuestionarioActivity.this, FimQuestionarioActivity.class);
        startActivity(intent);

        System.out.println("size respostas final:"+respostas.length);
        for(Integer resp: respostas){
            System.out.println("respostas final: "+resp);

        }
    }


}
