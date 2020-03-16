
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimentoCuboCaindo : MonoBehaviour
{
    public float velocidade = 0.01f;

    // Start is called before the first frame update
    void Start(){
        int numero =10;
        string nome = "Germano";
        Debug.Log("Hello Wolrd!");   
    }

    // Update is called once per frame
    void Update(){
    GameObject player = GameObject.FindGameObjectsWithTag("Cubo andando")[0]; // Referencia o objeto com Tag CuboMovimentando e Layer 0
      player.transform.Translate(velocidade,0,0); // Move o objeto Referenciado
      moverPersonagem(); // Chama metodo 
    }

    void moverPersonagem(){
        Vector3 move =new Vector3(0,0,velocidade); 
        transform.Translate(move); // Move o objeto atual 
    }
}

