using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Instanciar : MonoBehaviour
{
    public GameObject Cubo;
    // Start is called before the first frame update
    void Start()
    {
       GameObject obj = Instantiate(Cubo,new Vector3(0,0,0),Quaternion.Euler(0,0,0));   // Cria o objeto com sua posição e rotação
       Destroy(obj,10); // Destroi o objeto depois de 10 segundos
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
