using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
     float z = transform.position.z;                                        // Posição z do inimigo
     float playerZ=GameObject.Find("Player").transform.position.z;          // Posição z do player
     if(playerZ>z+2f){                                                     // Otimiza quantidade de objetos no mapa e aplica pontuação
        Player playerScript=GameObject.Find("Player").GetComponent<Player>();
        playerScript.pontosUI.GetComponent<UnityEngine.UI.Text>().text=(playerScript.pontos+=0.5).ToString(); // Incrementa e desenha no canvas, os pontos do player
        Destroy(this.gameObject);
     }   
    }
}
