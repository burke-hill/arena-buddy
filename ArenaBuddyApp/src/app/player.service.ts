import { Injectable } from "@angular/core";
import { Observable, observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { Player } from "./player";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})

export class PlayerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>(`${this.apiServerUrl}/player/all`)
  }

  public getPlayer(playerName: String): Observable<Player> {
    return this.http.get<Player>(`${this.apiServerUrl}/player/`+playerName);
  }
}
