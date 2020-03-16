
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ColisãoCuboAndando : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    
    void OnCollisionEnter(Collision collisionInfo) { // Ativa no momento inicial da colisão
      Debug.Log("Colidiu");
      collisionInfo.gameObject.GetComponent<ColisãoChão>().bateu=true; // Diz ao componente Controle do objeto com que colidiu que a variavel bateu é true
    }
     void OnCollisionStay(Collision collisionInfo) { // Ativa durante a colisão
      Debug.Log("Está Colidindo");
    }
}
