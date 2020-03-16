
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimentoCuboGrande : MonoBehaviour
{
  public float angle =0;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
  void Update()
    {
      angle++;
        GameObject inimigo = GameObject.Find("Cubo pequeno"); // Encontra o objeto inimigo
        // transform.Translate(0.02f,0.02f,0.02f); // Move o player
        transform.rotation=Quaternion.Euler(angle,angle,angle); // Rotaciona o player
        transform.localScale=new Vector3(2f,2f,2f); // Duplica o tamanho do player
        // transform.position= new Vector3(-1,2,0); Escolhe a posição inicial do player
        // inimigo.transform.Translate(0.02f,0.02f,0.02f); // Move o inimigo
        inimigo.transform.rotation =Quaternion.Euler(angle,angle,angle); // Rotaciona o inimigo
        inimigo.transform.localScale=new Vector3(0.5f,0.5f,0.5f); // Reduz o tamanho do inimigo

    }
}
