using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{

    public float speedHorizontal;
    public float speedVertical;
    public float yaw;
    public float pitch;
    public GameObject life;
    public GameObject[] lifes;

    public int lifeCount ;

    public float tempo;
    // Start is called before the first frame update
    void Start()
    {
        tempo=0f;
        lifeCount=3;
        lifes =new GameObject[3];
        speedHorizontal=2.0f;
        speedVertical=2.0f;
        yaw=0.0f;
        pitch=0.0f;
        Cursor.visible=false;
        Cursor.lockState=CursorLockMode.Locked;

        for(int i =0;i<lifes.Length;i++){
           lifes[i]=Instantiate(life,new Vector3(0,0,0),Quaternion.identity);
           lifes[i].transform.SetParent(GameObject.Find("VidaUI").transform);
            
           RectTransform rt = lifes[i].GetComponent<RectTransform>();
           rt.SetInsetAndSizeFromParentEdge(RectTransform.Edge.Left,600f+(i*30),rt.rect.width);
           rt.SetInsetAndSizeFromParentEdge(RectTransform.Edge.Top,-20f,rt.rect.height);
        }
    }

    // Update is called once per frame
    void Update()
    {
        tempo+=Time.deltaTime;
        Debug.Log(tempo);
        // Mover o mouse na tela
        pitch-=speedVertical*Input.GetAxis("Mouse Y");
        yaw+=speedHorizontal*Input.GetAxis("Mouse X");
        transform.eulerAngles=new Vector3(pitch,yaw,0);
        // Mover a camera na tela
        if(Input.GetKey("w")){
            transform.position+=transform.forward*0.4f;
        }
        if(Input.GetMouseButtonDown(0)){ // Mouse apertado
            detectarColisãoRay();
            
        }
    }
    void detectarColisãoRay(){
        RaycastHit ray;
        if(Physics.Raycast(transform.position,transform.forward,out ray,100f)){
            GameObject obj=ray.transform.gameObject;
           if(obj.tag=="Inimigo"){   // Destroi a bullet ao atirar nela
               Destroy(obj);
           }
        }else{
            // Não colidiu em nada
        } 
    }
    void OnCollisionEnter(Collision collision){
        if(collision.gameObject.tag=="Inimigo"){
            lifeCount--; 
            Destroy(lifes[lifeCount].gameObject); // Destroi uma vida
            Destroy(collision.gameObject); // Destroi a bullet ao tocar nela
            if(lifeCount==0){
            Application.LoadLevel(Application.loadedLevel); // Recomeça jogo
            }
        }
    }
}
